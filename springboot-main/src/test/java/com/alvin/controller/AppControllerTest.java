package com.alvin.controller;

import com.alvin.model.Person;
import com.alvin.model.QPerson;
import com.alvin.repository.PersonRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
public class AppControllerTest extends TestBase {

    @Test
    public void testFindOne() {
        //mockMvc.perform(
        //        MockMvcRequestBuilders.get("/user/findOne")
        //        .contentType(MediaType.APPLICATION_JSON_UTF8)
        //)
        //        .andExpect(MockMvcResultMatchers.status().isOk())
        //        .andReturn();
        //System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testLog() {
        log.info(new Date().toString());
    }

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private JPAQueryFactory queryFactory;

    @Test
    public void test() {
        QPerson query = QPerson.person;
        //queryFactory.select(query.id,query.age).from(query)
    }
}
