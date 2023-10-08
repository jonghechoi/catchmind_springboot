# 목차
1. [Catchmind 프로젝트 개요](#Catchmind-프로젝트-개요)
2. [담당 페이지 및 기능](#담당-페이지-및-기능)
3. [🚀 고도화](#-고도화)
4. [💡 느낀점](#-느낀점)  
<br/><br/>

# Catchmind 프로젝트 개요
레스토랑 예약 웹 서비스 Catchmind는 모바일 전용 애플리케이션 CatchTable을 모티브로 했습니다. <br/>
사용자-판매자를 연결하는 플랫폼이므로 일반 <span style='background-color: #FF3D00'>사용자</span>와 <span style='background-color: #FF3D00'>레스토랑 점주</span>가 사용할 수 있는 페이지를 구분하여 다양한 참여자의 시각에서 기능 구현을 했습니다. <br/>
<img src="https://github.com/jonghechoi/catchmind_springboot/assets/57426066/be1029a2-587d-446f-839b-885499b9fe2d" width="800" height="400">

<br/><br/>

# 담당 페이지 및 기능
총 3개의 페이지를 담당했습니다. 

- ### Index
  <img src="https://github.com/jonghechoi/catchmind_springboot/assets/57426066/5983b97e-7530-4869-bdb8-b32acf011741" width="400" height="200">

- ### 레스토랑 점주 페이지
  <img src="https://github.com/jonghechoi/catchmind_springboot/assets/57426066/f6030a04-f2c8-4290-8e7e-1d14d7735c82" width="400" height="200">
  <img src="https://github.com/jonghechoi/catchmind_springboot/assets/57426066/a7c65cc4-17dd-4cdf-9e57-85ec8b6b7a82" width="400" height="200">

- ### 관리자
  <img src="https://github.com/jonghechoi/catchmind_springboot/assets/57426066/904b10a1-b535-42ca-958b-76ac6e5ce35e" width="400" height="200">

<br/><br/>

# 🚀 고도화
![msa](https://github.com/jonghechoi/catchmind_springboot/assets/57426066/089694da-8f23-4b24-8fca-13b1001ea574)
  - CI/CD  
    1. 도커 컴포트로 web, was 컨테이너 배포
    2. Github Actions로 파이프라인 구성 → [링크](https://github.com/jonghechoi/review_msa/blob/master/.github/workflows/gradle.yml)
  - MSA
    고도화는 관리자에서 관리하는 리뷰 도메인을 MS로 구성했습니다. → [링크](https://github.com/jonghechoi/review_msa)
  - AOP  
    Logging, Exception 처리
    

<br/><br/>

# 💡 깨달은 점
  1. Git Flow를 도입하여 브랜치 구성, 커밋 메시지의 통일성 등을 프로젝트 시작 전에 잡을 것
  2. 기존 Mybatis에서 JPA로 전환하며 정확한 API 스펙의 구현 원리와 적용 방법을 이해할 것
  3. TDD의 중요성
