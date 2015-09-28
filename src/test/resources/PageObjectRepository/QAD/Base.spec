#Object Definitions
====================================================================================

required							xpath				//select[@class='required']
bookFrame							xpath				//div[contains(@id,'NB_App') and not(contains(@style,'none'))]//iframe[contains(@id, '_NB_Main_IFrame') and not(contains(@style,'none'))]
dockFrame							xpath				//iframe[contains(@id, '_NB_Dock_IFrame') and not(contains(@style,'none'))]
activityFrame						xpath				//iframe[contains(@id, 'distinct_activity_create_frame') and not(contains(@style,'none'))]
modalFrame							xpath				//iframe[contains(@id, 'modelOptionsEditFrame') and not(contains(@style,'none'))]
appFrame							xpath				//iframe[contains(@id, 'appiframeid') and not(contains(@style,'none'))]
peerMarkFrame						xpath				//iframe[contains(@id, 'peermarkFrame') and not(contains(@style,'none'))]
hideFrame							xpath				//div[contains(@style,'block')]//a[contains(@class, 'hideApp')]
originalityReportFrame				xpath				//iframe[contains(@id, 'originalityReportIframe') and not(contains(@style,'none'))]
ddl_orderButton						xpath				//a[@id='order-button']/span[@class='ui-selectmenu-status']
add_link							xpath				//span[@class='lpn_create']
addActivity							linkText			Add Activity
addFolder							linkText			Add Folder
lpn_icon							id					nb_lpLauncher
more_link							className			nb_expandDock		

====================================================================================