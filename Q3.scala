object stringFormat {
  def main(args: Array[String]): Unit = {
    formatNames("Benny")(toUpper(_))(Array());
    formatNames("Niroshan")(toLower(_))(Array(0, 1));
    formatNames("Saman")(toLower(_))(Array());
    formatNames("Kumara")(toLower(_))(Array(0,5));
  }

  def toUpper(name: String): String = {
    name.toUpperCase();
  }

  def toLower(name: String): String = {
    name.toLowerCase();
  }

  def formatNames(name: String)(function: String => String)(indexlist: Array[Int]): Unit = {
    var n = function(name)
    var index: Int = 0;
    while (index < indexlist.length) {
      var x = n.charAt(indexlist(index));
      n = n.substring(0, indexlist(index)) + x.toUpper + n.substring(
        indexlist(index) + 1
      ) 
      index = index + 1
    }
    println(n)
  }
}