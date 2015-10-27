#objectDefinition
================================================================================
topicList                           xpath         //*[@id='cl-topicview']//div[contains(@class,'topic-name')]
subTopic                            xpath          //*[@id='cl-topicview']//span[contains(text(),'${subtopic}')]
topicEditBtn                        xpath          //*[@id='cl-topicview']//span[contains(text(),'${subtopic}')]/../..//*[@id='editButton']
startDateInput                      css            #start-date-control>.datepicker>input
endDateInput                        css            #end-date-control>.datepicker>input
calendarDate                        xpath          //a[contains(text(),'${date}')]
doneBtn                             css            .ui-datepicker-close
saveScheduleBtn                     xpath          //andesite-button[@id='save']/button
cancelScheduleBtn                   xpath          (//andesite-button[@id='cancel']/button)[1]
editBtn                             xpath          //span[contains(text(),'${subtopic}')]/../..//andesite-button[@id='editButton']
descriptionTopic                    xpath          (//iron-autogrow-textarea)[1]//textarea 
title                               xpath          (//label[contains(text(),'Title')]/../input)[1]
clearBtn                            css             .date-clear
================================================================================