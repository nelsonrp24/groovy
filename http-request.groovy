/*Coment*/

//def url = new URL('http://groovy.codehaus.org/')
//def connection = url.openConnection()
//connection.requestMethod = 'GET'
//if (connection.responseCode == 200) {
	//println connection.responseCode
	//println connection.responseMessage
	//println connection.requestMethod
  //println connection.content.text
	//println connection.contentType
	//println connection.lastModified


	//connection.headerFields.each {
	//		println "> ${it}"
	//}

	//html = connection.content.text
	//html.grep() {${2/(.+)/(?1: )/}obj${2/(.+)/(?1: ->)/}

	//}

//} else {
//	println 'An error occurred: ' + connection.responseCode + ' ' + connection.responseMessage
//}


def html = "'<div class='logo' style='background-image:url(img/logos/netflix.png.pagespeed.ce.waguTf5Mzv.png)'></div>"

def matcher = html =~ /.*logos\/().*/

println matcher
