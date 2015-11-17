#Object Definitions
====================================================================================
courseBookTitle					css									#cl-course-pane-navbar
btnRollingWeekView							xpath								//*[@id='rollingWeekviewButton']/span
btnTopicView							xpath								//*[@id='topicviewButton']/span
btnjumpToWeek					xpath								//*[@id='jumpToWeekButton']/paper-material
monthDate						xpath								//span[@id='current-week-heading']/..//span[contains(@class,"date-range")]
expand_collapse					xpath								//span[@id='current-week-heading']/..//span[contains(@class,"date-range")]/../div[@id='weekCollapse']/paper-icon-button
addToWeek						xpath								//span[@id='current-week-heading']/../..//button[contains(text(),'Add to')]
currentWeekIcon					css									#current-week-icon
textWeek						xpath								//span[contains(text(),'current week')]/../h4
chapters						xpath								//div [contains(@class,"chapter-name")]
Today							xpath								//span[contains(text(),'Today')]
dayToAdd                                                xpath                                                          //*[@id='addDialog' and not (contains(@style,'display: none'))]//cl-date-icon[contains(.,'${Tue}')]
assignmentDescription                           xpath                                                           //*[@id='rollingWeeksContainer']//div[contains(text(),'${description}')]
offline_assignmentTitle                                 xpath                                                           (//span[contains(text(),'Non MindTap: ${title}')])[1]
offlineAssignment                                       xpath                                                            //div[contains(@class,'day-bar')]
offline_assignmentScore                                 xpath                                                            (//span[@id='totalDisplay'])[1]
offlineActivity                                         xpath                                                             //*[@id='rollingWeeksContainer']//*[@id='offline']/b
currentDescription                                      xpath                           //*[@id='cl-rolling-weekview']//div[contains(text(),'${description}')]
allDescription                                          css                             #activity .description                                                            
topicActivity                                           xpath                           //b[contains(text(),'Topic')]
allExpand                                               css                             .toggle iron-icon
areaExpanded                                            css                             #collapseWeek
ShowOrLessButton                                        xpath                           //div[contains(text(),'${description}')]/../div[contains(@class,'show-more-less')]
flag                                            xpath                                  (//span[@id='current-week-heading']/../../../../..//*[@icon="icons:flag"])[1]
points                                          xpath                           (//span[@id='current-week-heading']/../../../../..//span [@id="totalDisplay"])[1]
hideButton                          xpath                                       (//span[@id='current-week-heading']/../../../../..//andesite-button[@ id="hideButton"])[1]
editButton                          xpath                           (//span[@id='current-week-heading']/../../../../..//andesite-button[@ id="editButton"])[1]
deleteButton                        xpath                           (//span[@id='current-week-heading']/../../../../..//andesite-button[@ id="deleteButton"])[1]
stateToogle                         xpath                           //div[@id='position_1a']//*[@id='uncheckedLabel']
Toogle                              xpath                          //div[@id='position_1a']//*[@id='checkedLabel']
====================================================================================