package com.nberimen.hospitalmanagementsystem;

import com.nberimen.hospitalmanagementsystem.admin.AdminService;
import com.nberimen.hospitalmanagementsystem.admin.dto.AdminSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.appointment.AppointmentService;
import com.nberimen.hospitalmanagementsystem.appointment.dto.AppointmentSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.city.CityService;
import com.nberimen.hospitalmanagementsystem.city.dto.CitySaveRequestDto;
import com.nberimen.hospitalmanagementsystem.department.DepartmentService;
import com.nberimen.hospitalmanagementsystem.department.dto.DepartmentSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.doctor.DoctorService;
import com.nberimen.hospitalmanagementsystem.doctor.dto.DoctorSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.hospital.HospitalService;
import com.nberimen.hospitalmanagementsystem.hospital.dto.HospitalSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.patient.PatientService;
import com.nberimen.hospitalmanagementsystem.patient.dto.PatientSaveRequestDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class HospitalManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalManagementSystemApplication.class, args);
    }

    @Bean
    CommandLineRunner createInitialUsers(AdminService adminService,
                                         DoctorService doctorService,
                                         PatientService patientService,
                                         CityService cityService,
                                         HospitalService hospitalService,
                                         AppointmentService appointmentService,
                                         DepartmentService departmentService
    ) {

        return (args) -> {
            // init locations
            String[] sehirler = {"Adana", "Adıyaman", "Afyon", "Ağrı", "Amasya", "Ankara", "Antalya", "Artvin",
                    "Aydın", "Balıkesir", "Bilecik", "Bingöl", "Bitlis", "Bolu", "Burdur", "Bursa", "Çanakkale",
                    "Çankırı", "Çorum", "Denizli", "Diyarbakır", "Edirne", "Elazığ", "Erzincan", "Erzurum", "Eskişehir",
                    "Gaziantep", "Giresun", "Gümüşhane", "Hakkari", "Hatay", "Isparta", "İçel (Mersin)", "İstanbul",
                    "İzmir", "Kars", "Kastamonu", "Kayseri", "Kırklareli", "Kırşehir", "Kocaeli", "Konya", "Kütahya",
                    "Malatya", "Manisa", "Kahramanmaraş", "Mardin", "Muğla", "Muş", "Nevşehir", "Niğde", "Ordu", "Rize",
                    "Sakarya", "Samsun", "Siirt", "Sinop", "Sivas", "Tekirdağ", "Tokat", "Trabzon", "Tunceli",
                    "Şanlıurfa", "Uşak", "Van", "Yozgat", "Zonguldak", "Aksaray", "Bayburt", "Karaman", "Kırıkkale",
                    "Batman", "Şırnak", "Bartın", "Ardahan", "Iğdır", "Yalova", "Karabük", "Kilis", "Osmaniye",
                    "Düzce"};

            for (String sehir : sehirler) {
                CitySaveRequestDto cityDto = new CitySaveRequestDto();
                cityDto.setName(sehir);
                cityService.save(cityDto);
            }

            // init hospitals
            String[] hastaneler = {"Fethi Sekin Şehir Hastanesi", "Hasnatane2", "Hasnatane3"};

            for (String hastane : hastaneler) {
                HospitalSaveRequestDto hospital = new HospitalSaveRequestDto();
                hospital.setName(hastane);
                hospital.setCityId(23L);
                hospitalService.save(hospital);
            }

            // init depatments
            String[] birimler = {"Genel Cerrahi", "Deri ve Zührevi Hastalıkları (Cildiye)", "Nöroloji", "Kardiyoloji", "İç Hastalıkları (Dahiliye)"};

            for (String birim : birimler) {
                DepartmentSaveRequestDto department = new DepartmentSaveRequestDto();
                department.setName(birim);
                department.setHospitalId(1L);
                departmentService.save(department);
            }


            AdminSaveRequestDto admin = new AdminSaveRequestDto();
            admin.setIdentityNo(123L);
            admin.setPassword("123");
            adminService.save(admin);


            PatientSaveRequestDto patient = new PatientSaveRequestDto();
            patient.setIdentityNo(1234L);
            patient.setPassword("1234");
            patient.setFirstName("Necati");
            patient.setLastName("Berimen");
            patientService.save(patient);

            DoctorSaveRequestDto doctor = new DoctorSaveRequestDto();
            doctor.setFirstName("Ahmet");
            doctor.setLastName("Mehmet");
            doctor.setIdentityNo(12345L);
            doctor.setPassword("12345");
            doctor.setDepartmentId(1L);
            doctorService.save(doctor);

            DoctorSaveRequestDto doctor2 = new DoctorSaveRequestDto();
            doctor2.setFirstName("Ali");
            doctor2.setLastName("Veli");
            doctor2.setIdentityNo(123456L);
            doctor2.setPassword("123456");
            doctor2.setDepartmentId(2L);
            doctorService.save(doctor2);

            AppointmentSaveRequestDto appointment = new AppointmentSaveRequestDto();
            appointment.setAppointmentDate(new Date(122, 04, 22, 11, 30));
            appointment.setAppointmentTime(new Date(122, 04, 22, 11, 30));
            appointment.setPatientId(2L);
            appointment.setDoctorId(4L);
            appointmentService.save(appointment);

            AppointmentSaveRequestDto appointment2 = new AppointmentSaveRequestDto();
            appointment2.setAppointmentDate(new Date(122, 04, 22, 11, 00));
            appointment2.setAppointmentTime(new Date(122, 04, 22, 11, 00));
            appointment2.setPatientId(2L);
            appointment2.setDoctorId(3L);
            appointmentService.save(appointment2);

            AppointmentSaveRequestDto appointment3 = new AppointmentSaveRequestDto();
            appointment3.setAppointmentDate(new Date(122, 04, 19, 11, 00));
            appointment3.setAppointmentTime(new Date(122, 04, 19, 11, 00));
            appointment3.setPatientId(2L);
            appointment3.setDoctorId(3L);
            appointmentService.save(appointment3);

        };
    }

}
