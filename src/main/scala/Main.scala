import java.io.{InputStreamReader, BufferedReader}

import scala.collection.{mutable, Iterator}
import org.eclipse.swt.internal.win32.{TCHAR, OS}

/**
 * Created by FScoward on 2015/01/27.
 */
object Main {
  def main(args: Array[String]): Unit = {
    
    val pl = getProcessList
    val x = pl.drop(3)
    
    val list = WindowInfo.toWindowInfoList(x)
    list.foreach(println)
    
    // アクティブウィンドウを取得し、何を作業記録を行う

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


