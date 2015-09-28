#Object Definitions
====================================================================================

required							xpath				//select[@class='required']
organisation_nameBox				xpath				//div[@id='orgs']//input
courseKey_nameBox					xpath				//input[@id='searchFieldCourse']
readerMode_nameBox					xpath				//input[@id='searchFieldSnapshot']
parentOrg_link						xpath				//a[contains (@class,'orgtitle title')]
search_textField					xpath				//div[@id='courses']/div[@class='adminSearch']/input
readerModeCourses_link				linkText			Reader Mode Courses
coursesList							xpath				//div[@id='courses']//ul/li
orgList								css					.list.clui_columnlist>ul>li>a
cenagageSharedSnapshotList			xpath				//li[contains(@class,'item published snap admin_models')]
snapshotList						xpath				//li[contains(@class,'item  snap admin_models_snap_')]
											

====================================================================================