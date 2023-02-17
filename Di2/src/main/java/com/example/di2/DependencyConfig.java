package com.example.di2;

import com.example.di2.coffee.CoffeeRepository;
import com.example.di2.coffee.CoffeeService;
import com.example.di2.member.MemberRepository;
import com.example.di2.member.MemberService;

public class DependencyConfig {

        public MemberService memberService(){
            return new MemberService(new MemberRepository());
        }
        public MemberRepository memberRepository(){
            return new MemberRepository();
        }

        public CoffeeService coffeeService(){
            return new CoffeeService(new CoffeeRepository());
        }
        public CoffeeRepository coffeeRepository(){
        return new CoffeeRepository();
        }
}

