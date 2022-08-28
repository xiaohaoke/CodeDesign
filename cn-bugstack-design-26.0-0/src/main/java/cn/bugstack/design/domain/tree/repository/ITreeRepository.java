package cn.bugstack.design.domain.tree.repository;

import cn.bugstack.design.domain.tree.model.vo.TreeInfo;
import cn.bugstack.design.domain.tree.model.vo.TreeRulePoint;

import java.util.List;

/**
 * 微信公众号：bugstack虫洞栈 | 欢迎关注学习专题案例
 * 论坛：http://bugstack.cn
 * Create by 付政委 on @2019
 */
public interface ITreeRepository {

    TreeInfo queryTreeInfo(Long treeId);

    List<TreeRulePoint> queryTreeRulePointList(Long treeId);

}
