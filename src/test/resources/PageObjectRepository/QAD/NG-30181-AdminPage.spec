Page Title: MindTap Admin - Manage Masters

#Object Definitions
====================================================================================
courseClass                                                             css                                                 .listText						
mindtap_toolbar				   				xpath							//div[@class='nb_logoBox admin']
admin_dashboard								xpath							//h1[contains(text(),'${Admin Dashboard}')]
courseCount									css								.endcount
searchIcon									xpath							//img[contains(@src,'admin_search_icon')]
nextPageArrow                                                xpath                                                    //div[@class='pagearrow pageright']
input_search_ISBN           				xpath							//input[@id='searchField']
courseName									xpath							//a[@ class="title" and contains(text(),'${courseBook}')]
Btn_show_copy								css								a[title='Show Working Copy'] 
cousrse_list_controls						xpath							(//div[@ class="listControls"])[2]
courseCopy                                                      xpath                                   //div[contains(@class , 'working_copy')]
icon_course_edit							xpath								//*[@title = "Edit"]/img
Edit_Working_copy							xpath							//h2[contains(text(),'${Edit Master}')]
checkbox_Andesite_mode    					xpath							//input[@checked="checked" and @id="isAndesite"]
btn_save_Edit_Working_copy   				xpath							//a [@class="adminButton save"]
orgaizationTab          xpath           //*[@id='orgs_link']
inputOrganizationSearch         css               .adminSearch>input
courseOrganization              css                 .orgtitle
organizationsLink               css                 .orgback
courseProvisioned               xpath              //a[contains(@class,'coursetitle searchHighlightable title')]
courseCollege                   xpath               //a[contains(text(),'${organization}')]
provisionAppsIcon               css                 .delitem>img[alt="Provision Apps"]
appRegistryHeading              xpath               //h3[contains(text(),'App Registry')]
cengageNoMT_Activity            xpath               //div[contains(text(),'${provisionApp}')]
add_Activity                    xpath               //div[contains(text(),'${provisionApp}')]/../../a/img[@alt='Provision']
ProvisionList                   css               #app_registry>ul>li
snapshotList                    css             .item.snap

====================================================================================
@all, browsers
--------------------------------
inp_password
    below: inp_username 10 px
    hover: css 

@all
--------------------------------
inp_password
    above: inp_username 10 px

@browser
--------------------------------
inp_password
    below: inp_username > 10 px