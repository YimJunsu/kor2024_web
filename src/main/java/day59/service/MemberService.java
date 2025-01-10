package day59.service;


import day59.model.Dao.MemberDao;
import day59.model.Dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // 스프링 컨테이너(메모리)에 빈(인스턴스) 주입 (IOC)
public class MemberService {
    // 스프링 컨테이너(메모리)에 빈(인스턴스) 호출(DI)
    @Autowired private MemberDao memberDao;

    // [1] 회원가입 서비스
    public boolean signup(MemberDto memberDto){
        boolean result = memberDao.signup(memberDto);
        return result;
    }
    // [2] 로그인 서비스
    public boolean login(String mid, String mpwd){
        boolean result = memberDao.login(mid, mpwd);
        return result;
    }
}