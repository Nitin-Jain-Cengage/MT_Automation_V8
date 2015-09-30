Page Title: Cengage Learning - Login

#Object Definitions
====================================================================================
						
mindtap_toolbar				   				xpath							//div[@class='nb_logoBox admin']
admin_dashboard								xpath							//h1[contains(text(),'${Admin Dashboard}')]
input_search_ISBN           				xpath							//input[@id='searchField']
courseName									xpath							//a[@ class="title" and contains(text(),'${courseBook}')]
Btn_show_copy								css								a[title='Show Working Copy'] 
cousrse_list_controls						xpath							(//div[@ class="listControls"])[2]
icon_course_edit							css								.delitem.ui-button.clui-edit>img
Edit_Working_copy							xpath							//h2[contains(text(),'${Edit pop title}')]
checkbox_Andesite_mode    					xpath							//input[@checked="checked" and @id="isAndesite"]
btn_save_Edit_Working_copy   				xpath							//a [@class="adminButton save"]

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