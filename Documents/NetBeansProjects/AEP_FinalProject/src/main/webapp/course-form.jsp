<%@page import="models.Course"%>
<form action="courses?action=<%= request.getParameter("id") == null ? "create" : "edit" %>" method="post">
    <input type="hidden" name="id" value="<%= request.getAttribute("course") != null ? ((Course) request.getAttribute("course")).getId() : "" %>">
    <label>Title: </label>
    <input type="text" name="title" value="<%= request.getAttribute("course") != null ? ((Course) request.getAttribute("course")).getTitle() : "" %>" required><br>
    <label>Code: </label>
    <input type="text" name="code" value="<%= request.getAttribute("course") != null ? ((Course) request.getAttribute("course")).getCode() : "" %>" required><br>
    <label>Term: </label>
    <input type="text" name="term" value="<%= request.getAttribute("course") != null ? ((Course) request.getAttribute("course")).getTerm() : "" %>" required><br>
    <label>Schedule: </label>
    <input type="text" name="schedule" value="<%= request.getAttribute("course") != null ? ((Course) request.getAttribute("course")).getSchedule() : "" %>" required><br>
    <label>Delivery Method: </label>
    <input type="text" name="deliveryMethod" value="<%= request.getAttribute("course") != null ? ((Course) request.getAttribute("course")).getDeliveryMethod() : "" %>" required><br>
    <label>Qualifications: </label>
    <textarea name="qualifications" required><%= request.getAttribute("course") != null ? ((Course) request.getAttribute("course")).getPreferredQualifications() : "" %></textarea><br>
    <label>Compensation: </label>
    <input type="text" name="compensation" value="<%= request.getAttribute("course") != null ? ((Course) request.getAttribute("course")).getCompensation() : "" %>" required><br>
    <label>Institution ID: </label>
    <input type="number" name="institutionId" value="<%= request.getAttribute("course") != null ? ((Course) request.getAttribute("course")).getInstitutionId() : "" %>" required><br>
    <button type="submit">Submit</button>
</form>