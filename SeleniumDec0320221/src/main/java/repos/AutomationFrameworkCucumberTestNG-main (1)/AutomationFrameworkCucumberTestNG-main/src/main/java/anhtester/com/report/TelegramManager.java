package anhtester.com.report;

import anhtester.com.constants.FrameworkConstants;
import anhtester.com.helpers.Helpers;
import anhtester.com.utils.Log;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendDocument;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

import java.io.File;

public class TelegramManager {
    private static String Token = FrameworkConstants.TELEGRAM_TOKEN;
    // https://api.telegram.org/bot18745845:AAHtlc_TL7zlPEABHuTJy3J72XumY5LxWcE/getUpdates
    private static String ChatId = FrameworkConstants.TELEGRAM_CHATID;
    private static TelegramBot bot = new TelegramBot(Token);
    private static File input = new File(FrameworkConstants.EXTENT_REPORT_FILE_PATH);

    public static boolean sendFilePath(String filePath) {
        boolean success = false;
        try {
            File input = new File(Helpers.getCurrentDir() + filePath);
            SendDocument request = new SendDocument(ChatId, input).parseMode(ParseMode.HTML).disableNotification(true);
            SendResponse sendResponse = bot.execute(request);
            boolean ok = sendResponse.isOk();
            success = ok;
            if (ok != true) {
                Message message = sendResponse.message();
                Log.warn("Message response from Telegram: " + message);
            }
        } catch (Exception e) {
            Log.error("Error Send Report HTML to Telegram: " + e.getMessage());
        }
        return success;
    }

    public static void sendReportPath() {
        if (FrameworkConstants.SEND_REPORT_TO_TELEGRAM.toLowerCase().trim().equals(FrameworkConstants.YES)) {
            boolean Success = false;
            try {
                SendDocument request = new SendDocument(ChatId, input).parseMode(ParseMode.HTML).disableNotification(true);
                SendResponse sendResponse = bot.execute(request);
                boolean ok = sendResponse.isOk();
                Success = ok;
                if (ok != true) {
                    Message message = sendResponse.message();
                    Log.warn("Message response from Telegram: " + message);
                }
            } catch (Exception e) {
                Log.error("Error Send Report HTML to Telegram: " + e.getMessage());
            }
        }
    }

    // chỗ này check nếu gửi thành công thì xóa file luôn
//    public static boolean deleteReportFile() {
//        boolean success = false;
//        success = sendReportPath();
//        if (success == true) {
//            input.delete();
//        }
//        return success;
//    }

    public static boolean sendMessageText(String messageText) {
        SendMessage request = new SendMessage(ChatId, messageText);
        SendResponse sendResponse = bot.execute(request);
        boolean ok = sendResponse.isOk();
        if (ok == true) {
            Log.info("Send message to Telegram: " + messageText);
        } else {
            Log.info("Send message to Telegram: " + ok);
        }
        return ok;
    }

}
