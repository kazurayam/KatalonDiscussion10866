import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import groovy.json.JsonOutput

WebUI.openBrowser('')

WebUI.navigateToUrl('http://b.hatena.ne.jp/')

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_/a_'), 10)

def dataLayer = WebUI.executeJavaScript('return dataLayer;', [])

WebUI.comment("dataLayer is ${dataLayer}")

def jsonPayload = JsonOutput.toJson(dataLayer)
WebUI.comment("jsonPayload is \n${JsonOutput.prettyPrint(jsonPayload)}")

WebUI.closeBrowser()

