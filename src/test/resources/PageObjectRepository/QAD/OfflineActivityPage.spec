
#Object Definitions
==================================================================================================
offline_activity                                        xpath                                                           //*[@id='offline']/b
offline_assignmentScore                                 xpath                                                           //*[@id='value-panel']
offline_assignmentTitle                                 xpath                                                           (//label[contains(text(),'Title')]/../input)[2]
offline_assignmentDescription                           xpath                                                            (//iron-autogrow-textarea)[2]//textarea 
addOfflineAssignment_Btn                                xpath                                                            (//*[@id='addButton' and contains(@class,'cl-add-offline-activity')]/button)
addOfflineAssignment_Cancel                             xpath                                                            (//*[@id='cancelButton']/button)[1] 
practiceBtn                                             xpath                                                             //button[contains(text(),'Practice')]
AssociatedTopic                                         xpath                                   //cl-add-offline-activity//select[@ id="associatedTopic"]
topic                                                   xpath                                   //option[contains(text(),'${topic}')]
==================================================================================================