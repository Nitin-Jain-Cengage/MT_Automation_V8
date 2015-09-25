Page Title: Instructor SSO - Create Course Confirmation
        

#Object Definitions
====================================================================================
instructorCourseUrl						xpath							(//p[@ class='distributionOptions']/a)[1]

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