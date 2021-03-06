#!/usr/bin/env python
# -*- coding: utf-8 -*-
#
# Basic example for a bot that uses inline keyboards.
# This program is dedicated to the public domain under the CC0 license.

import logging
from telegram import InlineKeyboardButton, InlineKeyboardMarkup, ReplyKeyboardMarkup, ReplyKeyboardRemove
from telegram.ext import Updater, CommandHandler, CallbackQueryHandler, Job, ConversationHandler, MessageHandler, Filters

import paho.mqtt.client as mqtt
import json
import threading
import sys
import time

STATIC_PASSWORD = "pusik"
TRAIN_STATUS_REQUEST_PERIOD_S = 10

def callback_minute(bot, job):
    bot.send_message(job.context, text="callback timer up !")

def error(bot, update, error):
    logger.warn('Update "%s" caused error "%s"' % (update, error))


logging.basicConfig(format='%(asctime)s - %(name)s - %(levelname)s - %(message)s',
                    level=logging.INFO)

class UserSelection(object):
    def __init__(self):
        self.fromStationID = 0
        self.toStationID = 0

global chatIDs
chatIDs = dict()

global g_update
g_update = None


global mqtt_client

global gTrainStatusDict
gTrainStatusDict = None

global servers_status_dict
servers_status_dict = dict()

eng2kor_dict = {'MinwonServer': u'민원서버', 'MainServer':u'매인서버', 'Gateway': u'개이트웨이'}

FROM_STATION, TO_STATION, RESTART = range(3)

def reset_servers_status():
    global servers_status_dict
    for nodename in servers_status_dict:
        servers_status_dict[nodename] = 'off'

def getFromStationKeyboard():
    station_keyboard = [
        [InlineKeyboardButton(u"녹동", callback_data='100'),
        InlineKeyboardButton(u"소태", callback_data='101'),
        InlineKeyboardButton(u"학동 증심사입구", callback_data='102')],
        
        [InlineKeyboardButton(u"남광주", callback_data='103'),
        InlineKeyboardButton(u"문화전당(구도청)", callback_data='104'),
        InlineKeyboardButton(u"금남로4가", callback_data='105')],

        [InlineKeyboardButton(u"금남로5가", callback_data='106'),
        InlineKeyboardButton(u"양동시장", callback_data='107'),
        InlineKeyboardButton(u"돌고개", callback_data='108')],
        
        [InlineKeyboardButton(u"농성", callback_data='109'),
        InlineKeyboardButton(u"화정", callback_data='110'),
        InlineKeyboardButton(u"쌍촌", callback_data='111'),
        InlineKeyboardButton(u"운천", callback_data='112')],

        [InlineKeyboardButton(u"상무", callback_data='113'),
        InlineKeyboardButton(u"김대중컨벤션센터(마륵)", callback_data='114')],

        [InlineKeyboardButton(u"공항", callback_data='115'),
        InlineKeyboardButton(u"송정공원", callback_data='116'),
        InlineKeyboardButton(u"광주송정역", callback_data='117')],

        [InlineKeyboardButton(u"도산", callback_data='118'),
        InlineKeyboardButton(u"평동", callback_data='119')] ]
    return station_keyboard

def getToStationKeyboard():
    station_keyboard = [
        [InlineKeyboardButton(u"녹동", callback_data='1100'),
        InlineKeyboardButton(u"소태", callback_data='1101'),
        InlineKeyboardButton(u"학동 증심사입구", callback_data='1102')],
        
        [InlineKeyboardButton(u"남광주", callback_data='1103'),
        InlineKeyboardButton(u"문화전당(구도청)", callback_data='1104'),
        InlineKeyboardButton(u"금남로4가", callback_data='1105')],

        [InlineKeyboardButton(u"금남로5가", callback_data='1106'),
        InlineKeyboardButton(u"양동시장", callback_data='1107'),
        InlineKeyboardButton(u"돌고개", callback_data='1108')],
        
        [InlineKeyboardButton(u"농성", callback_data='1109'),
        InlineKeyboardButton(u"화정", callback_data='1110'),
        InlineKeyboardButton(u"쌍촌", callback_data='1111'),
        InlineKeyboardButton(u"운천", callback_data='1112')],

        [InlineKeyboardButton(u"상무", callback_data='1113'),
        InlineKeyboardButton(u"김대중컨벤션센터(마륵)", callback_data='1114')],

        [InlineKeyboardButton(u"공항", callback_data='1115'),
        InlineKeyboardButton(u"송정공원", callback_data='1116'),
        InlineKeyboardButton(u"광주송정역", callback_data='1117')],

        [InlineKeyboardButton(u"도산", callback_data='1118'),
        InlineKeyboardButton(u"평동", callback_data='1119')] ]
    return station_keyboard

def getStationButtons():
    return [[u'/시작',u'녹동', u'소태',u'학동증심사입구'],
            [u'남광주', u'문화전당',u'금남로4가',u'금남로5가'], 
            [u'양동시장', u'돌고개', u'농성', u'화정'], 
            [u'쌍촌',u'운천', u'상무', u'김대중',u'공항'],
            [u'송정공원', u'광주송정역',u'도산', u'평동']]
    

def start(bot, update, args, job_queue, chat_data):
    station_keyboard = getFromStationKeyboard()

    curChatID = update.message.chat_id
    chatIDs[curChatID] = UserSelection()

    print "start: chat_id = ", str(curChatID)

    reply_markup = ReplyKeyboardMarkup(getStationButtons(), one_time_keyboard=True) #InlineKeyboardMarkup(station_keyboard)
    update.message.reply_text(u'안녕, 어디 있니?', reply_markup=reply_markup)

    #print "args = ", args
    #global g_update
    #if args[0] == STATIC_PASSWORD:
    #    print "PASSWORD CORRECT, the bot activated !"
    #    g_update = update
    #    update.message.reply_text(u"민원 받는 모드 시작했습니다'")

    #################
    #chat_id = update.message.chat_id
    #job = job_queue.run_repeating(callback_minute, 10, first=None, context=chat_id)
    #update.message.reply_text("start function!") 
    return FROM_STATION

def stop(bot, update):
    global g_udpate
    if g_update != None:
        g_update = None
        update.message.reply_text(u'민원 받는 모드 긑었습니다')

def server_status(bot, update):
    global servers_status_dict
    if servers_status_dict is not None:
        ret_s = u"---- 서버 상태 ----\n"
        for nn in servers_status_dict:
            if nn not in eng2kor_dict:
                ret_s += str(nn) + ": " + str(servers_status_dict[nn]) + "\n"
            else:
                ret_s += eng2kor_dict[nn] + ": " + str(servers_status_dict[nn]) + "\n"
    update.message.reply_text(ret_s)


def getTrainStatusRequest():
    mqtt_client.publish("/keti/energy/fromtguserapp", "status_request_msg", 1)

def getAverageTemperature(trainID):
    sumtemp = (gTrainStatusDict[trainID]["T1TEMP"]+
            gTrainStatusDict[trainID]["T2TEMP"]+
            gTrainStatusDict[trainID]["T3TEMP"]+
            gTrainStatusDict[trainID]["T4TEMP"])
    return float(sumtemp)/4.0


def getAverageHumidity(trainID):
    sumtemp = (gTrainStatusDict[trainID]["T1HUM"]+
            gTrainStatusDict[trainID]["T2HUM"]+
            gTrainStatusDict[trainID]["T3HUM"]+
            gTrainStatusDict[trainID]["T4HUM"])
    return float(sumtemp)/4.0

def getStationID(stationName):
    try:
        stationIDdict =  {
            u'녹동': 100,
            u'소태': 101,
            u'학동증심사입구': 102,
            u'학동증심사': 102,
            u'학동증':102,
            u'학동':102,
            u'남광주': 103,
            u'문화전당(구도청)': 104,
            u'문화전당': 104,
            u'문화전':104,
            u'문화': 104,
            u'금남로4가' : 105,
            u'금남4':105,
            u'금4':105,
            u'금남고5가' : 106,
            u'금남5':106,
            u'금5':106,
            u'양동시장' : 107,
            u'돌고개' : 108,
            u'농성' : 109,
            u'화정' : 110,
            u'쌍촌' : 111,
            u'운천' : 112,
            u'상무' : 113,
            u'김대중컨벤션센터(마륵)' : 114,
            u'김대중': 114,
            u'김대':114,
            u'공항' : 115,
            u'송정공원' : 116,
            u'송정':116,
            u'광주송정역' : 117,
            u'광주송정':117,
            u'광주':117,
            u'도산' : 118,
            u'평동' : 119,
        }[stationName]
        return stationIDdict
    except:
        print "Exception non existing Station Name: ", stationName
        return None

def getStationName(stationID):
    return {
        100: u'녹동',
        101: u'소태',
        102: u'학동증심사입구',
        103: u'남광주',
        104: u'문화전당(구도청)',
        105: u'금남로4가',
        106: u'금남고5가',
        107: u'양동시장',
        108: u'돌고개',
        109: u'농성',
        110: u'화정',
        111: u'쌍촌',
        112: u'운천',
        113: u'상무',
        114: u'김대중컨벤션센터(마륵)',
        115: u'공항',
        116: u'송정공원',
        117: u'광주송정역',
        118: u'도산',
        119: u'평동',
    }[stationID]

def generateInformationMessage(possibleListOfTrains, fromStationID, work_dir):
    if possibleListOfTrains == None or len(possibleListOfTrains) == 0:
        return u'오고 있는 열차는 아직 없읍니다, 나중에 다시 해보세요'
    s = u"*탈수 있는 열차들:*\n"
    sorted_list = None
    # create tuple of trains and corresponding location info
    tuple_list = list()
    for i in possibleListOfTrains:
        tuple_list.append( (gTrainStatusDict[i]["Location"], i) )
    print 'tuple_list = ', tuple_list

    if work_dir == 0:
        sorted_list = sorted(tuple_list, reverse=True)
    else:
        sorted_list = sorted(tuple_list)
    print 'sorted_list = ', sorted_list

    for i in sorted_list:
        avgTemp = getAverageTemperature(i[1])
        avgHum = getAverageHumidity(i[1])
        #s+= getStationName(gTrainStatusDict[i]["Location"]), u' 역에서 오는 열차, 평균 온도는', avgTemp, u'C, 평균 습도는', avgHum, '%\n'
        s+= '*-* '+ getStationName(gTrainStatusDict[i[1]]["Location"]) + u' 역에서 오는 열차 '+ str(abs(int(gTrainStatusDict[i[1]]["Location"])-fromStationID)*2 )  + u'분후 도착 예정' + u' ,\n  평균 온도: ' + str(avgTemp) + u'C, 평균 습도: ' + str(avgHum) + '%\n'
    return s


def button(bot, update):
    query = update.callback_query
    chat_id = query.message.chat_id
    print 'query data = ', query.data
    print "button: chat_id = ", str(query.message.chat_id)

    ### validation of query.data being a number
    stationID = 0
    try:
        stationID = int(query.data)
    except:
        print "StationID must integer number"
        return


    #bot.edit_message_text(text="---- Selected option ---: %s " % query.data,
    #                      chat_id=query.message.chat_id,
    #                      message_id=query.message.message_id)
    if stationID < 1000:
        chatIDs[query.message.chat_id].fromStationID = stationID
        
        station_keyboard = getToStationKeyboard()
        reply_markup = InlineKeyboardMarkup(station_keyboard)
        #print 'station_keyboard = ', station_keyboard
        bot.sendMessage(chat_id=query.message.chat_id, text=u'어디까지 가니?', reply_markup=reply_markup)
    else:
        chatIDs[query.message.chat_id].toStationID = stationID
        work_dir = 0 if (chatIDs[chat_id].toStationID % 1000  - chatIDs[chat_id].fromStationID) > 0 else 1
        print 'work = ', work_dir, 'from',chatIDs[chat_id].fromStationID,'to', chatIDs[chat_id].toStationID
        
        if work_dir == 0: # from Nokdong to Pyeongdong direction
            print 'the following trains are coming (work=0)'
            possible_trains_list = list()
            for tid in gTrainStatusDict:
                if gTrainStatusDict[tid]["work"]==0 and gTrainStatusDict[tid]["Location"] <= chatIDs[chat_id].fromStationID:
                    print "subNum = ", tid
                    possible_trains_list.append(tid) 
  
            replymsg = generateInformationMessage(possible_trains_list, chatIDs[chat_id].fromStationID, work_dir) 
            bot.sendMessage(chat_id=query.message.chat_id, text=replymsg, parse_mode='Markdown')

        else: # from Pyeongdong to Nokdong direction
            print 'the following trains are coming (work=1)'
            possible_trains_list = list()
            for tid in gTrainStatusDict:
                if gTrainStatusDict[tid]["work"]==1 and gTrainStatusDict[tid]["Location"] >= chatIDs[chat_id].fromStationID:
                    print "subNum. = ", tid
                    possible_trains_list.append(tid)
            replymsg = generateInformationMessage(possible_trains_list, chatIDs[chat_id].fromStationID, work_dir) 
            bot.sendMessage(chat_id=query.message.chat_id, text=replymsg)




def help(bot, update):
    help_msg = u"/start <비밀번호> 를 내고 민원 읽기 모드으로 밖월수 있습니다..\n"
    help_msg += u"/server_status 서버 상태 정보를 받기.\n"
    update.message.reply_text(help_msg)


def error(bot, update, error):
    logging.warning('Update "%s" caused error "%s"' % (update, error))

# Create the Updater and pass it your bot's token.
"""
updater = Updater("444481571:AAH7A2MKPnhgfgaxxyKABOpDArjAWWuEU24")

updater.dispatcher.add_handler(CommandHandler('start', start,
                                    pass_args=True,
                                    pass_job_queue=True,
                                    pass_chat_data=True))
updater.dispatcher.add_handler(CallbackQueryHandler(button))
updater.dispatcher.add_handler(CommandHandler('help', help))
updater.dispatcher.add_handler(CommandHandler('server_status', server_status))
updater.dispatcher.add_error_handler(error)
"""

######### mqtt client #######

def status_reporter(client, topic):
    if topic == "/keti/energy/statusrequest":
        client.publish("/keti/energy/systemstatus", '{"nodename":"TelegramUserAppBotServer", "status":"on"}')
        return True
    return False

def on_connect(client, userdata, flags, rc):
    print "Connected to MQTT Broker with result code ", str(rc)

    res = client.subscribe("/keti/energy/totguserapp", 1)
    print "res = ", res
    time.sleep(1)
    res = client.subscribe("/keti/energy/statusrequest",1)
    print "res = ", res
    print "subscribed to multiple topics..."

def saveTrainStatusDict(json_parsed_msg):
    global gTrainStatusDict
    #json_parsed_msg["subway"]
    if gTrainStatusDict == None:
        gTrainStatusDict = dict()
    else:
        # cleaning the gTrainStatusDict
        for ts in gTrainStatusDict.keys():
            del gTrainStatusDict[ts]

    for l in json_parsed_msg["subway"]:
        gTrainStatusDict[l["Train"]] = dict(l)
        #print l["Location"]
        #print l
    print "show gTrainStatusDict: "
    for ts in gTrainStatusDict:
        print ts,
    print

def on_message(client, userdata, msg):
    try:
        if status_reporter(client, msg.topic) == False: 
            #print '-->', msg.payload
            #global g_update
            if True: #g_update != None:
                #g_update.message.reply_text(msg.payload)
                json_parsed_msg = json.loads(msg.payload)
                #print 'json_parsed_msg ->',
                #print json_parsed_msg
                saveTrainStatusDict(json_parsed_msg)
                #g_update.message.reply_text(s)
    except:
        print sys.exc_info()

mqtt_client = mqtt.Client()
mqtt_client.on_connect = on_connect
mqtt_client.on_message = on_message

mqtt_client.connect('117.16.136.173', 1883, 600)

def MQTTStarterThread():
    global mqtt_client
    mqtt_client.loop_start()

def TrainStatusRequesterThread():
    global mqtt_client
    try:
        while True:
            time.sleep(TRAIN_STATUS_REQUEST_PERIOD_S)
            reset_servers_status()
            #print "."
            mqtt_client.publish("/keti/energy/fromtguserapp", '{"request":"status"}', 1)
            print ","
    except:
        print "Exitting !"

def cancel(bot, update):
    user = update.message.from_user
    logger.info("User %s canceled the conversation." % user.first_name)
    update.message.reply_text('Bye! I hope we can talk again some day.',
                              reply_markup=ReplyKeyboardRemove())

def from_station(bot, update):
    print 'from_station update.message = ', update.message

    print 'from StationID = ', getStationID(update.message.text)

    if update.message.text == u'시작' or update.message.text == u'/시작' or update.message.text==u'안녕':
        return RESTART


    curChatID = update.message.chat_id
    stID = getStationID(update.message.text)
    if stID != None:
        chatIDs[curChatID].fromStationID = stID

    reply_markup = ReplyKeyboardMarkup(getStationButtons(), one_time_keyboard=True)
    update.message.reply_text(u'어디까지 가니?', reply_markup=reply_markup)    
    return TO_STATION

def to_station(bot, update):
    print 'to_station update.message = ', update.message
    print 'to StationID = ', getStationID(update.message.text)

    if update.message.text == u'시작' or update.message.text == u'/시작' or update.message.text==u'안녕':
        return RESTART

    chat_id = update.message.chat_id
    stID = getStationID(update.message.text)
    if stID != None:
        chatIDs[chat_id].toStationID = stID
    
    work_dir = 0 if (chatIDs[chat_id].toStationID  - chatIDs[chat_id].fromStationID) > 0 else 1
    print 'work = ', work_dir, 'from',chatIDs[chat_id].fromStationID,'to', chatIDs[chat_id].toStationID
    

    global gTrainStatusDict
    if work_dir == 0: # from Nokdong to Pyeongdong direction
        print 'the following trains are coming (work=0)', gTrainStatusDict
        possible_trains_list = list()
        for tid in gTrainStatusDict:
            if gTrainStatusDict[tid]["work"]==0 and gTrainStatusDict[tid]["Location"] <= chatIDs[chat_id].fromStationID:
                print "subNum = ", tid
                possible_trains_list.append(tid) 
  
        replymsg = generateInformationMessage(possible_trains_list, chatIDs[chat_id].fromStationID, work_dir) 
        bot.sendMessage(chat_id=chat_id, text=replymsg, parse_mode='Markdown')

    else: # from Pyeongdong to Nokdong direction
        print 'the following trains are coming (work=1)'
        possible_trains_list = list()
        for tid in gTrainStatusDict:
            if gTrainStatusDict[tid]["work"]==1 and gTrainStatusDict[tid]["Location"] >= chatIDs[chat_id].fromStationID:
                print "subNum. = ", tid
                possible_trains_list.append(tid)
        replymsg = generateInformationMessage(possible_trains_list, chatIDs[chat_id].fromStationID, work_dir) 
        bot.sendMessage(chat_id=chat_id, text=replymsg, parse_mode='Markdown')




    return ConversationHandler.END

def skip(bot, update):
    user = update.message.from_user
    logger.info("User did select skip")
    update.message.reply_text('또 확인하고 싶으면 "안녕"이라고 해\n')

    return TO_STATION

global updater
def main():
    global updater
    # Create the EventHandler and pass it your bot's token.
    updater = Updater("444481571:AAH7A2MKPnhgfgaxxyKABOpDArjAWWuEU24")

    # Get the dispatcher to register handlers
    dp = updater.dispatcher

    # Add conversation handler with the states GENDER, PHOTO, LOCATION and BIO
    conv_handler = ConversationHandler(
        entry_points=[CommandHandler(u'시작', start, 
                                    pass_args=True, 
                                    pass_job_queue=True,
                                    pass_chat_data=True),
                        CommandHandler(u'start', start, 
                                    pass_args=True, 
                                    pass_job_queue=True,
                                    pass_chat_data=True)],

        states={
            FROM_STATION: [MessageHandler(Filters.text, from_station),
                            CommandHandler('skip', skip)],

            TO_STATION: [MessageHandler(Filters.text, to_station)],

            RESTART: [MessageHandler(Filters.text, start)]

            #PHOTO: [MessageHandler(Filters.photo, photo),
            #        CommandHandler('skip', skip_photo)],

            #LOCATION: [MessageHandler(Filters.location, location),
            #           CommandHandler('skip', skip_location)],

            #BIO: [MessageHandler(Filters.text, bio)]
        },

        fallbacks=[CommandHandler('cancel', cancel)]
    )

    dp.add_handler(conv_handler)

    # log all errors
    dp.add_error_handler(error)

    # Start the Bot
    updater.start_polling()

    # Run the bot until you press Ctrl-C or the process receives SIGINT,
    # SIGTERM or SIGABRT. This should be used most of the time, since
    # start_polling() is non-blocking and will stop the bot gracefully.
    #rustamchange# idle is outside #updater.idle()

print "--1--"
t = threading.Thread(target=MQTTStarterThread())
t.daemon = True
t.start()
print "--2--"


# Start the Bot
#updater.start_polling()
time.sleep(5)

print "--3--"

print '-- before main --'
if __name__ == '__main__':
    main()
print '--- after main ---'

# forever cycle starts
requester_t = threading.Thread(target=TrainStatusRequesterThread())
#requester_t.daemon = True
print "--4--"
requester_t.start()



print "--5--"



# Run the bot until the user presses Ctrl-C or the process receives SIGINT,
# SIGTERM or SIGABRT
updater.idle()

print "--6--"
