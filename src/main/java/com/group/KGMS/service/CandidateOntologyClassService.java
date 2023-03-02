package com.group.KGMS.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.group.KGMS.entity.CandidateOntologyClass;

import java.io.IOException;

/**
 * @BelongsProject: Knowledge-Graph-Management-System-back-end
 * @BelongsPackage: com.group.KGMS.service
 * @Author: zt
 * @CreateTime: 2022-12-22  21:32
 * @Description: 候选本体类父子信息的service
 */
public interface CandidateOntologyClassService extends IService<CandidateOntologyClass> {

    /*
     * @Description: 向某个候选本体中添加一个类，需要给定要添加的类的名称，其父类的ID，
     *               以及其所属的候选本体的ID，这个方法不仅会向数据库中添加新的类，同时也会向owl文件中添加新的类
     * @Author: zt
     * @Date: 2023/3/2 16:12
     * @param: [className 要添加的类的名称, parentId 父类ID, belongCandidateId 所属的候选本体的ID]
     * @return: boolean
     **/
    boolean save(String className, Integer parentId, Integer belongCandidateId) throws IOException;

    /*
     * @Description: 根据候选本体的id，获取一个根类，根类里用孩子列表来进行存储父子关系，用树形json工具类进行处理
     * @Author: zt
     * @Date: 2022/12/22 21:54
     * @param: [candidateOntologyId 候选本体的id]
     * @return: com.group.KGMS.entity.CandidateOntologyClass
     **/
    CandidateOntologyClass getRootClassByCandidateOntologyId(Integer CandidateOntologyId);

}
