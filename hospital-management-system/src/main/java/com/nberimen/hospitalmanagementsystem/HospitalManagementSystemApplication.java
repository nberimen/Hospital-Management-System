package com.nberimen.hospitalmanagementsystem;

import com.nberimen.hospitalmanagementsystem.admin.Admin;
import com.nberimen.hospitalmanagementsystem.admin.AdminMapper;
import com.nberimen.hospitalmanagementsystem.admin.AdminService;
import com.nberimen.hospitalmanagementsystem.admin.dto.AdminSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.city.City;
import com.nberimen.hospitalmanagementsystem.city.CityService;
import com.nberimen.hospitalmanagementsystem.city.dto.CityDto;
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

        };
    }

}
