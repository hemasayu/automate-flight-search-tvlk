import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

WebUI.openBrowser(GlobalVariable.flightUrl)

WebUI.setViewPortSize(GlobalVariable.viewportWidth, GlobalVariable.viewportHeight)

WebUI.refresh()

WebUI.click(findTestObject('search_section/input_origin'))

WebUI.clearText(findTestObject('search_section/input_origin'))

WebUI.setText(findTestObject('search_section/input_origin'), 'Semarang')

WebUI.waitForElementPresent(findTestObject('search_section/autocomplete_origin'), 0)

def originAutocomplete = WebUI.getText(findTestObject('search_section/autocomplete_origin'))

WebUI.verifyMatch(originAutocomplete, '^Semarang.*', true, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('search_section/autocomplete_origin'))

WebUI.click(findTestObject('search_section/input_arrival'))

WebUI.clearText(findTestObject('search_section/input_arrival'))

WebUI.setText(findTestObject('search_section/input_arrival'), 'Medan')

WebUI.waitForElementPresent(findTestObject('search_section/autocomplete_arrival'), 0)

def arrivalAutocomplete = WebUI.getText(findTestObject('search_section/autocomplete_origin'))

WebUI.verifyMatch(arrivalAutocomplete, '^Medan.*', true, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('search_section/autocomplete_arrival'))

WebUI.click(findTestObject('search_section/return_checkbox'))

WebUI.verifyElementPresent(findTestObject('search_section/input_ReturnDate'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('search_section/input_departure_date'))

WebUI.click(findTestObject('search_section/select_2_oct'))

WebUI.click(findTestObject('search_section/return_15_oct'))

WebUI.click(findTestObject('search_section/input_passenger'))

WebUI.click(findTestObject('search_section/passenger_adult_plus_btn'))

WebUI.click(findTestObject('search_section/passenger_infant_plus_btn'))

WebUI.click(findTestObject('search_section/passenger_done_btn'))

WebUI.click(findTestObject('search_section/input_seat_class'))

WebUI.click(findTestObject('search_section/seat_economy'))

WebUI.click(findTestObject('search_section/search_flights_btn'))

WebUI.delay(15)

def url = WebUI.getUrl()

def origin = WebUI.getText(findTestObject('search_result/search_result_header'))

WebUI.verifyMatch(url, '^https://www.traveloka.com/en-id/flight/fulltwosearch?.*', true, FailureHandling.STOP_ON_FAILURE)

//def arrival = WebUI.getText(findTestObject('search_result/date_passenger_class_info'))
WebUI.verifyMatch(origin, '^Semarang.*', true, FailureHandling.STOP_ON_FAILURE)

