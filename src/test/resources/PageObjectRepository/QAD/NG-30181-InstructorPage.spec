Page Title: Instructor SSO - Instructor Resource Center
        

#Object Definitions
====================================================================================

pageTitle							xpath 							//div[@ class="page-title"]/*[contains(text(),'${pageTitle}')]
input_book_search					xpath 							//input[@id='searchword']
icon_search							css								.searchbutton
checkbox_course						css								.radiocell>input
btn_add								xpath 							//*[contains(text(),'Add Selected to Instructor Resource Center')]
courseOperation						xpath    						//a[contains(text(),'${Course Option}')]

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