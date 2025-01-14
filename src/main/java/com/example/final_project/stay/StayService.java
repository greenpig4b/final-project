package com.example.final_project.stay;

import com.example.final_project._core.errors.exception.Exception401;
import com.example.final_project._core.errors.exception.Exception404;
import com.example.final_project.company.Company;
import com.example.final_project.company.CompanyRepository;
import com.example.final_project.company.CompanyService;
import com.example.final_project.company.SessionCompany;
import com.example.final_project.option.Option;
import com.example.final_project.option.OptionRepository;
import com.example.final_project.room.Room;
import com.example.final_project.room.RoomRepository;
import com.example.final_project.user.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StayService {
    private final OptionRepository optionRepository;
    private final RoomRepository roomRepository;
    private final StayRepository stayRepository;
    private final CompanyRepository companyRepository;

    //숙소등록
    @Transactional
    public StayResponse.Save register(StayRequest.SaveDTO reqDTO, SessionCompany sessionCompany){
        //1. 인증처리
        Company company = companyRepository.findById(sessionCompany.getId()).orElseThrow(
                () -> new Exception404("해당 기업을 찾을 수 없습니다")
        );
        //2. 권한처리
        if (company.getId() != sessionCompany.getId()){
            throw new Exception401("숙소를 등록할 권한이 없습니다.");
        }

        Stay stay = stayRepository.save(reqDTO.toEntity(company));

        return new StayResponse.Save(stay,stay.getOptions());
    }
}
