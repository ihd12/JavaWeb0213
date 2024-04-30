package org.zerock.b01.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.b01.domain.Member;
import org.zerock.b01.dto.MemberDTO;
import org.zerock.b01.repository.MemberRepository;

@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class MemberServiceImpl implements MemberService {
  private final ModelMapper modelMapper;
  private final MemberRepository memberRepository;

  @Override
  public void register(MemberDTO memberDTO) {
    memberRepository.save(modelMapper.map(memberDTO, Member.class));
  }

  @Override
  public MemberDTO readOne(String memberId) {
    return modelMapper.map(memberRepository.findById(memberId),MemberDTO.class);
  }
}
