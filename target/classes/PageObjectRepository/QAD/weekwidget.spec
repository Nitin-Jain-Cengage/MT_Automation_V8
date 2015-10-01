#Object Definitions
====================================================================================
courseBookTitle					css									cl-course-pane-navbar 
btnRWV							xpath								//*[@id='rollingWeekviewButton']/paper-material
btnTV							xpath								//*[@id='topicviewButton']/paper-material
btnjumpToWeek					xpath								//*[@id='jumpToWeekButton']/paper-material
monthDate						xpath								//span[@id='current-week-heading']/..//span[contains(@class,"date-range")]
expand_collapse					xpath								//span[@id='current-week-heading']/..//span[contains(@class,"date-range")]/..//iron-icon[@class="style-scope paper-icon-button x-scope iron-icon-0"]
addToWeek						xpath								//span[@id='current-week-heading']/../..//button[contains(text(),'Add to')]
currentWeekIcon					css									#current-week-icon
textWeek						xpath								//span[contains(text(),'current week')]/../h4
chapters						xpath								//div [contains(@class,"chapter-name")]
Today							xpath								//span[contains(text(),'Today')]
====================================================================================