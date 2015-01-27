/**
 * Created by FScoward on 2015/01/27.
 */
case class WindowInfo (imageName: String,
                        PID: String,
                        sessionName: String,
                        session: String,
                        memoryUsage: String,
                        status: String,
                        userName: String,
                        cpuTime: String,
                        windowTitle: String)

object WindowInfo {
    
  /**
   * csv形式のテキスト複数行をWindowInfoのリスト形式に変換
   * */
  def toWindowInfoList(windowInfoStringList: List[String]) = {
    windowInfoStringList.map(info => {
      toWindowInfo(info)
    }).toList
  }
  
  /**
   * csv形式のテキスト1行をWindowInfoに格納する
   * */
  private def toWindowInfo(windowInfoString: String) = {
    val separated = windowInfoString.split(",")
    WindowInfo(separated(0), separated(1), separated(2), separated(3), separated(4), separated(5), separated(6), separated(7), separated(8))
  }
 
}