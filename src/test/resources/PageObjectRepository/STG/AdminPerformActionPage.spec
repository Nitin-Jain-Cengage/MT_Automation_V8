#Object Definitions

====================================================================================
createMaster                                      css                                                   .adminButtons>a
masters_link					  id  							masters_link
orgs_link					  id  							orgs_link
createNeXtBook_btn				  linktext 						Create Master
admin_btn					  css  							.adminButtons
neXtBookName_txtField				  id							nb.name
courseMode_radioButton				  id							isReaderOnly1
neXtBookDescription_txtField			  id						    description
coreTextISBN_txtField 				  id  							componentISBN
ssoISBN_txtField				  id 							isbn
neXtBookLearningPathName_txtField		  id  						    nb.lp.name
createNeXtBookFormSubmit_btn			  linktext  					Save
refresh_btn 					  linktext 					    Refresh
notPublished_btn 				  css 							img[alt='Not Published']
provisionApps_btn     				  xpath							//li[contains(@class,'item  app_library')]//img[@alt  'Provision']) 
organizationsDashboard_link			  linktext 					    Organizations
appLib_link			                  id							apps_link
neXtBookSearch_inputBox  			  css                           #searchField
neXtBookSearchInputBoxActivated_txtField	  xpath  						//input[@id='searchField']
learningPathTab_link                             classname			nb_lpBg
glossaryApps_btn                                 css  img[alt='Glossary']
status_link                                      css  .nb_indent_half.clui-button.clui-status
statusLinkWorkingCopy                            xpath  //div[contains(@class,'working_copy')]/div[@class='listText']/div[@class='listMeta']/a[contains(@class, 'clui-status')]
statusLinkNextBook                               xpath  //li[contains(@class,'admin_models_master')]/div//div[@class='listText']/div[@class='listMeta']/a[contains(@class, 'clui-status')]
tabs                                             id  nb_manage
published_btn                           	 xpath  		//img[@alt ='Published']
masterBook                                       xpath			//div[@class='original']/div[@class='listText']/a
info_link                                        xpath					//div[contains(@class,'working_copy')]/div[@class='listText']/div[@class='listMeta']/a[contains(@class,'infolink')]
publishMaster                                    xpath			//img[@alt ='Publish Master']
noResults                                        classname                      noresults
logo						css					.nb_logoBox
loggedID					css					#_username_div
statusTableId_list		xpath		//div[@class='status']/table[contains(@class,'ruled')]/tbody/tr/td[4]
saveToMaster_list		 xpath				//li[contains(@class, 'has_copy')]/div/div[contains(@class,'listText')]
save_status_row		 xpath					//div[@class='status']/table[contains(@class,'ruled')]/tbody/tr[contains(.,'Save')]
username 			id 					id_username_div
visibleTabs			xpath 				 .//div[@id  ='nb_manage']/h1/a
workingCopyButton				 xpath 						//*[contains(@alt,'Masters With Working Copies')]
masterBookList   css		.listContainer
modeValue			xpath		//div[@class='filterToggle admin_filter']/a/img[contains(@alt,'${mode}')]
admin_models_master             xpath		//li[contains(@class, 'item  master admin_models_master')]
options	           xpath		//img[@alt='${option}']
thumbtitle		xpath			//div[@class='lpn_thumbTitle']
logoBox			xpath			//a[@class = 'nb_logoBox']
title                   xpath                (//a[contains(text(),'${title}')])[1]
====================================================================================
    