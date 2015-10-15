#Object Definitions
====================================================================================
courseBookTitle					css									#cl-course-pane-navbar
btnRWV							xpath								//*[@id='rollingWeekviewButton']/paper-material
btnTV							xpath								//*[@id='topicviewButton']/paper-material
btnjumpToWeek					xpath								//*[@id='jumpToWeekButton']/paper-material
monthDate						xpath								//span[@id='current-week-heading']/..//span[contains(@class,"date-range")]
expand_collapse					xpath								//span[@id='current-week-heading']/..//span[contains(@class,"date-range")]/../div[@id='weekCollapse']/paper-icon-button
addToWeek						xpath								//span[@id='current-week-heading']/../..//button[contains(text(),'Add to')]
currentWeekIcon					css									#current-week-icon
textWeek						xpath								//span[contains(text(),'current week')]/../h4
chapters						xpath								//div [contains(@class,"chapter-name")]
Today							xpath								//span[contains(text(),'Today')]
dayToAdd                                                xpath                                                           //header[contains(text(),'${Tue}')]
offline_assignmentDescription                           xpath                                                           (//div[contains(text(),'${description}')])[1]
offline_assignmentTitle                                 xpath                                                           (//span[contains(text(),'Non MindTap: ${title}')])[1]
offlineAssignment                                       xpath                                                            //div[contains(@class,'day-bar')]
offline_assignmentScore                                 xpath                                                            (//span[@id='totalDisplay'])[1]
offlineActivity                                         xpath                                                             //*[@id='offline']/b


====================================================================================