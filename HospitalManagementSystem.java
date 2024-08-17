import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Patient {
    private String patientId;
    private String name;
    private String birthDate;
    private String address;
    private String contactNumber;
    private String gender;

    public Patient(String patientId, String name, String birthDate, String address, String contactNumber, String gender) {
        this.patientId = patientId;
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.contactNumber = contactNumber;
        this.gender = gender;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getGender() {
        return gender;
    }
}

class PatientManagement {
    private List<Patient> patients = new ArrayList<>();

    public void registerPatient(Patient patient) {
        patients.add(patient);
    }

    public Patient getPatientDetails(String patientId) {
        for (Patient patient : patients) {
            if (patient.getPatientId().equals(patientId)) {
                return patient;
            }
        }
        return null;
    }

    public List<Patient> getAllPatients() {
        return patients;
    }
}

class Appointment {
    private String appointmentId;
    private Patient patient;
    private String appointmentDate;
    private String doctorName;
    private String reason;

    public Appointment(String appointmentId, Patient patient, String appointmentDate, String doctorName, String reason) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.appointmentDate = appointmentDate;
        this.doctorName = doctorName;
        this.reason = reason;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getReason() {
        return reason;
    }
}

class AppointmentScheduler {
    private List<Appointment> appointments = new ArrayList<>();

    public void scheduleAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public Appointment getAppointmentDetails(String appointmentId) {
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentId().equals(appointmentId)) {
                return appointment;
            }
        }
        return null;
    }

    public List<Appointment> getAllAppointments() {
        return appointments;
    }
}

class MedicalRecord {
    private String recordId;
    private Patient patient;
    private List<String> diagnoses;
    private List<String> medications;
    private List<String> testResults;

    public MedicalRecord(String recordId, Patient patient, String diagnoses, String medications, String testResults) {
        this.recordId = recordId;
        this.patient = patient;
        this.diagnoses = new ArrayList<>();
        this.medications = new ArrayList<>();
        this.testResults = new ArrayList<>();
        for (String diagnosis : diagnoses.split(",")) {
            this.diagnoses.add(diagnosis.trim());
        }
        for (String medication : medications.split(",")) {
            this.medications.add(medication.trim());
        }
        for (String testResult : testResults.split(",")) {
            this.testResults.add(testResult.trim());
        }
    }

    public String getRecordId() {
        return recordId;
    }

    public Patient getPatient() {
        return patient;
    }

    public List<String> getDiagnoses() {
        return diagnoses;
    }

    public List<String> getMedications() {
        return medications;
    }

    public List<String> getTestResults() {
        return testResults;
    }
}

class EHRManagement {
    private List<MedicalRecord> medicalRecords = new ArrayList<>();

    public void addMedicalRecord(MedicalRecord record) {
        medicalRecords.add(record);
    }

    public MedicalRecord getMedicalRecord(String recordId) {
        for (MedicalRecord record : medicalRecords) {
            if (record.getRecordId().equals(recordId)) {
                return record;
            }
        }
        return null;
    }

    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecords;
    }
}

class Invoice {
    private String invoiceId;
    private Patient patient;
    private double amount;

    public Invoice(String invoiceId, Patient patient, double amount) {
        this.invoiceId = invoiceId;
        this.patient = patient;
        this.amount = amount;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public Patient getPatient() {
        return patient;
    }

    public double getAmount() {
        return amount;
    }
}

class BillingSystem {
    private List<Invoice> invoices = new ArrayList<>();

    public void generateInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

    public Invoice getInvoiceDetails(String invoiceId) {
        for (Invoice invoice : invoices) {
            if (invoice.getInvoiceId().equals(invoiceId)) {
                return invoice;
            }
        }
        return null;
    }

    public List<Invoice> getAllInvoices() {
        return invoices;
    }
}

class MedicalSupply {
    private String supplyId;
    private String name;
    private int quantity;
    private double price;

    public MedicalSupply(String supplyId, String name, int quantity, double price) {
        this.supplyId = supplyId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getSupplyId() {
        return supplyId;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}

class InventoryManagement {
    private List<MedicalSupply> supplies = new ArrayList<>();

    public void addSupply(MedicalSupply supply) {
        supplies.add(supply);
    }

    public MedicalSupply getSupplyDetails(String supplyId) {
        for (MedicalSupply supply : supplies) {
            if (supply.getSupplyId().equals(supplyId)) {
                return supply;
            }
        }
        return null;
    }

    public void updateSupplyQuantity(String supplyId, int newQuantity) {
        MedicalSupply supply = getSupplyDetails(supplyId);
        if (supply != null) {
            supply = new MedicalSupply(supply.getSupplyId(), supply.getName(), newQuantity, supply.getPrice());
        }
    }

    public List<MedicalSupply> getAllSupplies() {
        return supplies;
    }
}

class Staff {
    private String staffId;
    private String name;
    private String role;
    private String department;

    public Staff(String staffId, String name, String role, String department) {
        this.staffId = staffId;
        this.name = name;
        this.role = role;
        this.department = department;
    }

    public String getStaffId() {
        return staffId;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getDepartment() {
        return department;
    }
}

class StaffManagement {
    private List<Staff> staffList = new ArrayList<>();

    public void addStaff(Staff staff) {
        staffList.add(staff);
    }

    public Staff getStaffDetails(String staffId) {
        for (Staff staff : staffList) {
            if (staff.getStaffId().equals(staffId)) {
                return staff;
            }
        }
        return null;
    }

    public List<Staff> getAllStaff() {
        return staffList;
    }
}

public class HospitalManagementSystem {
    private static PatientManagement patientManagement = new PatientManagement();
    private static AppointmentScheduler appointmentScheduler = new AppointmentScheduler();
    private static EHRManagement ehrManagement = new EHRManagement();
    private static BillingSystem billingSystem = new BillingSystem();
    private static InventoryManagement inventoryManagement = new InventoryManagement();
    private static StaffManagement staffManagement = new StaffManagement();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Hospital Management System");
            System.out.println("1. Manage Patients");
            System.out.println("2. Manage Appointments");
            System.out.println("3. Manage EHR");
            System.out.println("4. Manage Billing");
            System.out.println("5. Manage Inventory");
            System.out.println("6. Manage Staff");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    managePatients(scanner);
                    break;
                case 2:
                    manageAppointments(scanner);
                    break;
                case 3:
                    manageEHR(scanner);
                    break;
                case 4:
                    manageBilling(scanner);
                    break;
                case 5:
                    manageInventory(scanner);
                    break;
                case 6:
                    manageStaff(scanner);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void managePatients(Scanner scanner) {
        System.out.println("1. Register Patient");
        System.out.println("2. View Patient");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Enter Patient ID:");
                String patientId = scanner.nextLine();
                System.out.println("Enter Name:");
                String name = scanner.nextLine();
                System.out.println("Enter Birth Date:");
                String birthDate = scanner.nextLine();
                System.out.println("Enter Address:");
                String address = scanner.nextLine();
                System.out.println("Enter Contact Number:");
                String contactNumber = scanner.nextLine();
                System.out.println("Enter Gender:");
                String gender = scanner.nextLine();

                Patient patient = new Patient(patientId, name, birthDate, address, contactNumber, gender);
                patientManagement.registerPatient(patient);
                System.out.println("Patient registered successfully.");
                break;
            case 2:
                System.out.println("Enter Patient ID:");
                patientId = scanner.nextLine();
                Patient retrievedPatient = patientManagement.getPatientDetails(patientId);
                if (retrievedPatient != null) {
                    System.out.println("Patient ID: " + retrievedPatient.getPatientId());
                    System.out.println("Name: " + retrievedPatient.getName());
                    System.out.println("Birth Date: " + retrievedPatient.getBirthDate());
                    System.out.println("Address: " + retrievedPatient.getAddress());
                    System.out.println("Contact Number: " + retrievedPatient.getContactNumber());
                    System.out.println("Gender: " + retrievedPatient.getGender());
                } else {
                    System.out.println("Patient not found.");
                }
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void manageAppointments(Scanner scanner) {
        System.out.println("1. Schedule Appointment");
        System.out.println("2. View Appointment");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Enter Appointment ID:");
                String appointmentId = scanner.nextLine();
                System.out.println("Enter Patient ID:");
                String patientId = scanner.nextLine();
                Patient patient = patientManagement.getPatientDetails(patientId);
                if (patient == null) {
                    System.out.println("Patient not found.");
                    break;
                }
                System.out.println("Enter Appointment Date:");
                String appointmentDate = scanner.nextLine();
                System.out.println("Enter Doctor Name:");
                String doctorName = scanner.nextLine();
                System.out.println("Enter Reason:");
                String reason = scanner.nextLine();

                Appointment appointment = new Appointment(appointmentId, patient, appointmentDate, doctorName, reason);
                appointmentScheduler.scheduleAppointment(appointment);
                System.out.println("Appointment scheduled successfully.");
                break;
            case 2:
                System.out.println("Enter Appointment ID:");
                appointmentId = scanner.nextLine();
                Appointment retrievedAppointment = appointmentScheduler.getAppointmentDetails(appointmentId);
                if (retrievedAppointment != null) {
                    System.out.println("Appointment ID: " + retrievedAppointment.getAppointmentId());
                    System.out.println("Patient Name: " + retrievedAppointment.getPatient().getName());
                    System.out.println("Appointment Date: " + retrievedAppointment.getAppointmentDate());
                    System.out.println("Doctor Name: " + retrievedAppointment.getDoctorName());
                    System.out.println("Reason: " + retrievedAppointment.getReason());
                } else {
                    System.out.println("Appointment not found.");
                }
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void manageEHR(Scanner scanner) {
        System.out.println("1. Add Medical Record");
        System.out.println("2. View Medical Record");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Enter Record ID:");
                String recordId = scanner.nextLine();
                System.out.println("Enter Patient ID:");
                String patientId = scanner.nextLine();
                Patient patient = patientManagement.getPatientDetails(patientId);
                if (patient == null) {
                    System.out.println("Patient not found.");
                    break;
                }
                System.out.println("Enter Diagnoses (comma-separated):");
                String diagnoses = scanner.nextLine();
                System.out.println("Enter Medications (comma-separated):");
                String medications = scanner.nextLine();
                System.out.println("Enter Test Results (comma-separated):");
                String testResults = scanner.nextLine();

                MedicalRecord record = new MedicalRecord(recordId, patient, diagnoses, medications, testResults);
                ehrManagement.addMedicalRecord(record);
                System.out.println("Medical record added successfully.");
                break;
            case 2:
                System.out.println("Enter Record ID:");
                recordId = scanner.nextLine();
                MedicalRecord retrievedRecord = ehrManagement.getMedicalRecord(recordId);
                if (retrievedRecord != null) {
                    System.out.println("Record ID: " + retrievedRecord.getRecordId());
                    System.out.println("Patient Name: " + retrievedRecord.getPatient().getName());
                    System.out.println("Diagnoses: " + retrievedRecord.getDiagnoses());
                    System.out.println("Medications: " + retrievedRecord.getMedications());
                    System.out.println("Test Results: " + retrievedRecord.getTestResults());
                } else {
                    System.out.println("Medical record not found.");
                }
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void manageBilling(Scanner scanner) {
        System.out.println("1. Generate Invoice");
        System.out.println("2. View Invoice");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Enter Invoice ID:");
                String invoiceId = scanner.nextLine();
                System.out.println("Enter Patient ID:");
                String patientId = scanner.nextLine();
                Patient patient = patientManagement.getPatientDetails(patientId);
                if (patient == null) {
                    System.out.println("Patient not found.");
                    break;
                }
                System.out.println("Enter Amount:");
                double amount = scanner.nextDouble();
                scanner.nextLine();

                Invoice invoice = new Invoice(invoiceId, patient, amount);
                billingSystem.generateInvoice(invoice);
                System.out.println("Invoice generated successfully.");
                break;
            case 2:
                System.out.println("Enter Invoice ID:");
                invoiceId = scanner.nextLine();
                Invoice retrievedInvoice = billingSystem.getInvoiceDetails(invoiceId);
                if (retrievedInvoice != null) {
                    System.out.println("Invoice ID: " + retrievedInvoice.getInvoiceId());
                    System.out.println("Patient Name: " + retrievedInvoice.getPatient().getName());
                    System.out.println("Amount: " + retrievedInvoice.getAmount());
                } else {
                    System.out.println("Invoice not found.");
                }
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void manageInventory(Scanner scanner) {
        System.out.println("1. Add Medical Supply");
        System.out.println("2. View Medical Supply");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Enter Supply ID:");
                String supplyId = scanner.nextLine();
                System.out.println("Enter Name:");
                String name = scanner.nextLine();
                System.out.println("Enter Quantity:");
                int quantity = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter Price:");
                double price = scanner.nextDouble();
                scanner.nextLine();

                MedicalSupply supply = new MedicalSupply(supplyId, name, quantity, price);
                inventoryManagement.addSupply(supply);
                System.out.println("Medical supply added successfully.");
                break;
            case 2:
                System.out.println("Enter Supply ID:");
                supplyId = scanner.nextLine();
                MedicalSupply retrievedSupply = inventoryManagement.getSupplyDetails(supplyId);
                if (retrievedSupply != null) {
                    System.out.println("Supply ID: " + retrievedSupply.getSupplyId());
                    System.out.println("Name: " + retrievedSupply.getName());
                    System.out.println("Quantity: " + retrievedSupply.getQuantity());
                    System.out.println("Price: " + retrievedSupply.getPrice());
                } else {
                    System.out.println("Medical supply not found.");
                }
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void manageStaff(Scanner scanner) {
        System.out.println("1. Add Staff");
        System.out.println("2. View Staff");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Enter Staff ID:");
                String staffId = scanner.nextLine();
                System.out.println("Enter Name:");
                String name = scanner.nextLine();
                System.out.println("Enter Role:");
                String role = scanner.nextLine();
                System.out.println("Enter Department:");
                String department = scanner.nextLine();

                Staff staff = new Staff(staffId, name, role, department);
                staffManagement.addStaff(staff);
                System.out.println("Staff added successfully.");
                break;
            case 2:
                System.out.println("Enter Staff ID:");
                staffId = scanner.nextLine();
                Staff retrievedStaff = staffManagement.getStaffDetails(staffId);
                if (retrievedStaff != null) {
                    System.out.println("Staff ID: " + retrievedStaff.getStaffId());
                    System.out.println("Name: " + retrievedStaff.getName());
                    System.out.println("Role: " + retrievedStaff.getRole());
                    System.out.println("Department: " + retrievedStaff.getDepartment());
                } else {
                    System.out.println("Staff not found.");
                }
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}
