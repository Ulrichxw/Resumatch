## **📄📎 I. Overview**  

**RESUMATCH** is a web-based platform designed to make the job application process easier for applicants and employers. It allows applicants to create profiles containing their educational background, work experience, achievements, certifications, soft skills, and hard skills. Using the information saved in their profiles, applicants can generate resumes tailored to the requirements of their chosen job positions through the Gemini API. The platform also recommends job vacancies based on their qualifications. Meanwhile, employers can post job openings and manage applications, while administrators review and approve job postings before they become available on the platform.


---

## **🤖 II. Feature**  

**AI-Powered Resume Generation** 
ResuMatch allows applicants to generate resumes using the information saved in their profiles, such as education, work experience, achievements, certifications, and skills. Through the Gemini API, the system uses these details along with the selected job description to create a tailored resume that highlights the applicant's qualifications relevant to the position. This eliminates the need to manually create a new resume for every job application.


---

## **🏗 III. System Architecture**  

### **🌐 Frontend**  
- **Technologies**: HTML, CSS, JavaScript  
- **Features**:  
  - Responsive design for various devices.  
  - Fetch API for communication with the backend.
  - Resume Formatting  

### **🖥 Backend**  
- **Language**: Java  

## **💻 IV. Applied OOP Concepts**  
- **Inheritance**:  
   - Applicant, Employer and Admin extend User. The four handlers extend ApiHandler.  
- **Polymorphism**:  
   - each User subclass overrides getRoleName() and getWelcomeMessage(), and each handler overrides respond(). The five match rules also share one score() method. 
- **Encapsulation**:  
   - fields are private with getters and setters. Setters refuse bad data, and status changes like approve() and close() check the current status first.  
- **Abstraction**:  
   - User and ApiHandler are abstract classes, and MatchRule is an interface.  

---

## **👥 V. Members**  
- **Lead Developer**:  
   - John Ulrich P. Fernandez  
- **UI Designer**:  
   - Alison Tatlonghari 
- **Documentation**:  
   - Czarina Sulit  
