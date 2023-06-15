package com.fan.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fan.R;
import com.fan.domain.EduTeacher;
import com.fan.domain.vo.EduTeacherReq;
import com.fan.mapper.EduTeacherMapper;
import com.fan.service.EduTeacherService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("eduTeacher")
@RestController
@CrossOrigin
public class EduTeacherController {

    @Autowired
    private EduTeacherMapper eduTeacherMapper;
    @Autowired
    private EduTeacherService eduTeacherService;

    @GetMapping("list")
    public R getAllEduTeacher() {
        List<EduTeacher> eduTeachers = eduTeacherMapper.selectList(null);
        return R.ok().data("items", eduTeachers);
    }

    @PostMapping("page/{current}/{limit}")
    public R page(@PathVariable Integer current, 
                            @PathVariable Integer limit, 
                            @RequestBody EduTeacherReq eduTeacherReq) {
        Page<EduTeacher> page = new Page<>(current, limit);
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(eduTeacherReq.getLevel() != null, EduTeacher::getLevel, eduTeacherReq.getLevel())
                        .like(StringUtils.isNotEmpty(eduTeacherReq.getName()), EduTeacher::getName, eduTeacherReq.getName());
        eduTeacherService.page(page, wrapper);
        return R.ok().data("item", page.getRecords()).data("total",page.getTotal());
    }
    
    @PostMapping("delete")
    public R delete(@RequestBody List<String> params){
        List<Long> idList = new ArrayList<>();
        idList.add(0,1189389726308478977L);
        boolean b = eduTeacherService.removeByIds(idList);
        if (b){
            return R.ok().message("删除成功");
        }else {
            return R.error().message("删除失败");
        }
    }
    
    @ResponseBody
    @PostMapping("update")
    public R updateEduTeacher(@RequestBody EduTeacher eduTeacher){
        boolean b = eduTeacherService.updateById(eduTeacher);
        if (b){
            return R.ok().message("更新成功");
        }else {
            return R.error().message("更新失败");
        }
    }
}