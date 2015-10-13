Page Title: Cengage Learning - Login

#Object Definitions
====================================================================================
user_Logout                                                             css                                                                     .style-scope.cl-user-profile-menu>a
inp_username    							css 									#_username_id
inp_password    							css 									#_password_id
btn_signin     								css 									input.goButton
icon_logout									css										#logout_link
sso_username								css										#emailId
sso_password								css										#password
sso_signin									xpath									//input[@type='submit']
icon_signout								xpath									//*[contains(text(),'Sign Out')]

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