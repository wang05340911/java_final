<table>
    <thead>
        <tr>
            <th>Title</th>
            <th>Code</th>
            <th>Term</th>
            <th>Schedule</th>
            <th>Delivery Method</th>
            <th>Compensation</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <% List<Course> courses = (List<Course>) request.getAttribute("courses"); %>
        <% for (Course course : courses) { %>
            <tr>
                <td><%= course.getTitle() %></td>
                <td><%= course.getCode() %></td>
                <td><%= course.getTerm() %></td>
                <td><%= course.getSchedule() %></td>
                <td><%= course.getDeliveryMethod() %></td>
                <td><%= course.getCompensation() %></td>
                <td>
                    <a href="courses?action=edit&id=<%= course.getId() %>">Edit</a>
                    <a href="courses?action=delete&id=<%= course.getId() %>" onclick="return confirm('Are you sure?')">Delete</a>
                </td>
            </tr>
        <% } %>
    </tbody>
</table>
<a href="courses?action=create">Add New Course</a>