CREATE DATABASE IF NOT EXISTS AEP;

USE AEP;

-- Drop existing tables if they exist (to avoid conflicts)
DROP TABLE IF EXISTS Notifications;
DROP TABLE IF EXISTS Requests;
DROP TABLE IF EXISTS Courses;
DROP TABLE IF EXISTS AcademicProfessionals;
DROP TABLE IF EXISTS AcademicInstitutions;
DROP TABLE IF EXISTS Users;

-- Users Table
CREATE TABLE Users (
    UserID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Email VARCHAR(255) UNIQUE NOT NULL,
    Password VARCHAR(255) NOT NULL,
    UserType ENUM('AcademicProfessional', 'AcademicInstitution') NOT NULL
);

-- Academic Institutions Table
CREATE TABLE AcademicInstitutions (
    InstitutionID INT PRIMARY KEY, -- Matches UserID for institutions
    Address VARCHAR(255),
    CoursesOffered TEXT,
    CONSTRAINT fk_academic_user FOREIGN KEY (InstitutionID) REFERENCES Users(UserID) ON DELETE CASCADE
);

-- Academic Professionals Table
CREATE TABLE AcademicProfessionals (
    ProfessionalID INT PRIMARY KEY, -- Matches UserID for professionals
    Institution VARCHAR(255), -- Affiliation (e.g., University name)
    AcademicPosition VARCHAR(255),
    EducationBackground TEXT,
    AreaOfExpertise TEXT,
    CONSTRAINT fk_professional_user FOREIGN KEY (ProfessionalID) REFERENCES Users(UserID) ON DELETE CASCADE
);

-- Courses Table
CREATE TABLE Courses (
    CourseID INT AUTO_INCREMENT PRIMARY KEY,
    InstitutionID INT NOT NULL,
    Title VARCHAR(255) NOT NULL,
    Code VARCHAR(50) NOT NULL,
    Term VARCHAR(10) NOT NULL,
    Schedule VARCHAR(50) NOT NULL,
    DeliveryMethod ENUM('In-Person', 'Remote', 'Hybrid') NOT NULL,
    QualificationsRequired TEXT,
    Compensation DECIMAL(10, 2),
    CONSTRAINT fk_course_institution FOREIGN KEY (InstitutionID) REFERENCES AcademicInstitutions(InstitutionID) ON DELETE CASCADE
);

-- Requests Table
CREATE TABLE Requests (
    RequestID INT AUTO_INCREMENT PRIMARY KEY,
    CourseID INT NOT NULL,
    ProfessionalID INT NOT NULL,
    RequestDate DATE NOT NULL,
    Status ENUM('Pending', 'Accepted', 'Rejected') NOT NULL,
    CONSTRAINT fk_request_course FOREIGN KEY (CourseID) REFERENCES Courses(CourseID) ON DELETE CASCADE,
    CONSTRAINT fk_request_professional FOREIGN KEY (ProfessionalID) REFERENCES AcademicProfessionals(ProfessionalID) ON DELETE CASCADE
);

-- Notifications Table
CREATE TABLE Notifications (
    NotificationID INT AUTO_INCREMENT PRIMARY KEY,
    RequestID INT NOT NULL,
    ProfessionalID INT NOT NULL,
    NotificationText TEXT NOT NULL,
    NotificationDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_notification_request FOREIGN KEY (RequestID) REFERENCES Requests(RequestID) ON DELETE CASCADE,
    CONSTRAINT fk_notification_professional FOREIGN KEY (ProfessionalID) REFERENCES AcademicProfessionals(ProfessionalID) ON DELETE CASCADE
);