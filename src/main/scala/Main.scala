import java.io.{PrintWriter, InputStreamReader, BufferedReader}

import org.joda.time.format.ISODateTimeFormat
import org.slf4j.LoggerFactory

import scala.collection.{mutable, Iterator}
import org.eclipse.swt.internal.win32.{TCHAR, OS}
import scala.concurrent.duration.{DurationInt, DurationLong}
import com.typesafe.scalalogging.{LazyLogging, Logger}

/**
 * Created by FScoward on 2015/01/27.
 */
object Main {
  def main(args: Array[String]): Unit = {
    
    // アクティブウィンドウを取得し、何を作業記録を行う
    val LOGGER = LoggerFactory.getLogger(this.getClass)
    val term = 1
    
    while(true){
      
      LOGGER.debug(s"${getForegroundWindowTitle}")

      Thread.sleep((term seconds).toMillis)
    }

  }
  
  /**
   * 最前面ウィンドウのタイトルを取得する
   * */
  private def getForegroundWindowTitle = {
    // ウィンドウハンドル
    val hwnd = OS.GetForegroundWindow()
    // ウィンドウタイトルの格納先
    var tchar: TCHAR = new TCHAR(OS.CP_INSTALLED, 1000)
    // ウィンドウタイトルをtcharに詰める
    OS.GetWindowText(hwnd, tchar, 1000)
    val length = OS.GetWindowTextLength(hwnd)
    tchar.toString(0, length)
  }
  
  /**
   * プロセス一覧の取得
   * */
  private def getProcessList: List[String] = {
    val pb = new ProcessBuilder("tasklist", "/V", "/FO", "CSV")
    // todo: try catch
    val bs = new BufferedReader(new InputStreamReader(pb.start().getInputStream))
    Iterator.continually(bs.readLine()).takeWhile(_ != null).toList
  }
}


