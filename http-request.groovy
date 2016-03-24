/*Coment*/
def url = new URL('http://10.10.10.43:8081/artifactory/CodingApp/com/nisum/CodingApp/')
def listDirs   = []
def connection = url.openConnection()
connection.requestMethod = 'GET'
if (connection.responseCode == 200) {
   def dirs
   html = connection.content.text

   html.eachLine{
        if (it =~ /a href\=\"\w+/){
           dirs = (it =~ /\"\>(.+)\/\<\/a\>/)[ 0 ][ 1 ]
           listDirs.push(dirs)
        }
   }
}else {
        println 'An error occurred: ' + connection.responseCode + ' ' + connection.responseMessage
}
//println listDirs
def urlWar
def listWars = []

listDirs.each{
        urlWar = new URL('http://10.10.10.43:8081/artifactory/CodingApp/com/nisum/CodingApp/'+it)
        def wardir = it
        def connectionWar = urlWar.openConnection()
        connectionWar.requestMethod = 'GET'

        if (connectionWar.responseCode == 200) {
        def wars
           html = connectionWar.content.text

           html.eachLine{

                if (it =~ /\.war\"/){
                   wars = (it =~ /\"(.+)\.war\"/)[ 0 ][ 1 ]
                   finalUrl = "$wardir-$wars"
                   listWars.push(finalUrl)
                }
           }
        }
}
//println listWars
println listWars.join(",")
return listWars.join(",")
