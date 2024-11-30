<!<!-- User will enter registration information here -->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 0;
            }
            .register-container {
                max-width: 400px;
                margin: 100px auto;
                background: white;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
            h1 {
                text-align: center;
                color: #333;
            }
            form {
                display: flex;
                flex-direction: column;
                gap: 15px;
            }
            label {
                font-weight: bold;
            }
            input {
                padding: 10px;
                font-size: 16px;
                border: 1px solid #ccc;
                border-radius: 4px;
            }
            button {
                background-color: #007BFF;
                color: white;
                padding: 10px;
                border: none;
                border-radius: 4px;
                font-size: 16px;
                cursor: pointer;
            }
            button:hover {
                background-color: #0056b3;
            }
            .login-link {
                text-align: center;
                margin-top: 10px;
            }
            .login-link a {
                text-decoration: none;
                color: #007BFF;
            }
            .login-link a:hover {
                text-decoration: underline;
            }
        </style>
    </head>
    <body>
        <div class="register-container">
            <h1>Register</h1>
            <form method="post" action="http://localhost:8080/AEP_FinalProject/RegisterServlet">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" placeholder="Enter your name" required>
                
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" placeholder="Enter your email" required>
                
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" placeholder="Enter your password" required>
                
                 <label for="userType">User Type:</label>
                <select id="userType" name="userType" required>
                    <option value="professional">Professional</option>
                    <option value="institution">Institution</option>
                </select>

                <%-- Conditional Fields for Professionals --%>
                <div id="professionalFields" style="display:none;">
                    <label for="currentInstitution">Current Institution:</label>
                    <input type="text" id="currentInstitution" name="currentInstitution" placeholder="Enter your current institution">

                    <label for="academicPosition">Academic Position:</label>
                    <input type="text" id="academicPosition" name="academicPosition" placeholder="Enter your academic position">
                </div>

                <%-- Conditional Fields for Institutions --%>
                <div id="institutionFields" style="display:none;">
                    <label for="institutionName">Institution Name:</label>
                    <input type="text" id="institutionName" name="institutionName" placeholder="Enter institution name">
                </div>
                
                <button type="submit">Register</button>
            </form>
            <div class="login-link">
                <p>Already have an account? <a href="login.jsp">Login here</a>.</p>
            </div>
        </div>
                
                <script>
                    
            // Show/Hide fields based on user type selection
            document.getElementById('userType').addEventListener('change', function() {
                var userType = this.value;
                if (userType === 'professional') {
                    document.getElementById('professionalFields').style.display = 'block';
                    document.getElementById('institutionFields').style.display = 'none';
                } else if (userType === 'institution') {
                    document.getElementById('institutionFields').style.display = 'block';
                    document.getElementById('professionalFields').style.display = 'none';
                }
            });

            // Trigger change event on page load to show the correct fields
            document.getElementById('userType').dispatchEvent(new Event('change'));
        </script>
    </body>
</html>
