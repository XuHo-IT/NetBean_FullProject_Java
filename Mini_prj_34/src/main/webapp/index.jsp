<!DOCTYPE html>

<!DOCTYPE html>
<html>
    <head>
        <title>Add Student</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
        <h1>Add New Student</h1>
        <form action="Servlet" method="post">
            <div class="form-group row">
                <label for="studentID" class="col-sm-2 col-form-label">Student ID</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="studentID" name="id" placeholder="Enter Student ID" >
                </div>
            </div>
            <div class="form-group row">
                <label for="name" class="col-sm-2 col-form-label">Name</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="name" name="name" placeholder="Enter Name">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Gender</label>
                <div class="col-sm-10">
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="gender" id="male" value="Male">
                        <label class="form-check-label" for="M">Male</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="gender" id="female" value="Female">
                        <label class="form-check-label" for="F">Female</label>
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <label for="dob" class="col-sm-2 col-form-label">Date of birth</label>
                <div class="col-sm-10">
                    <input type="date" class="form-control" id="dob" name="dob">
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </body>
</html>
