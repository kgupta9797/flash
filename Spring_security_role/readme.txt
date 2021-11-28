this Project has  implement role based security for admin and student
admin can have an access an delete
student can have only create request


configure(AuthenticationManagerBuilder auth) // for decalreing roles 

protected void configure(HttpSecurity http) throws Exception { //roles with action
		http.
		
		method is used