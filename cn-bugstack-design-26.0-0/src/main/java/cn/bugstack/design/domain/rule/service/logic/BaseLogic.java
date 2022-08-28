package cn.bugstack.design.domain.rule.service.logic;

import cn.bugstack.design.domain.rule.model.vo.DecisionMatter;
import cn.bugstack.design.domain.rule.model.vo.TreeNodeLineInfo;
import cn.bugstack.design.infrastructure.common.Constants;

import java.util.List;

/**
 * 微信公众号：bugstack虫洞栈 | 专注原创技术专题案例
 */
public abstract class BaseLogic extends LogicConfig implements LogicFilter {

    @Override
    public Long filter(String matterValue, List<TreeNodeLineInfo> treeNodeLineInfoList) {
        for (TreeNodeLineInfo nodeLine : treeNodeLineInfoList) {
            if (decisionLogic(matterValue, nodeLine)) return  nodeLine.getNodeIdTo();
        }
        return Constants.Global.TreeNullNode;
    }

    @Override
    public abstract String matterValue(DecisionMatter decisionMatter);

    private boolean decisionLogic(String matterValue, TreeNodeLineInfo nodeLine) {
        switch (nodeLine.getRuleLimitType()) {
            case Constants.RuleLimitType.EQUAL:
                return matterValue.equals(nodeLine.getRuleLimitValue());
            case Constants.RuleLimitType.LT:
                return Double.parseDouble(matterValue) < Double.parseDouble(nodeLine.getRuleLimitValue());
            case Constants.RuleLimitType.GE:
                return Double.parseDouble(matterValue) >= Double.parseDouble(nodeLine.getRuleLimitValue());
            default:
                return false;
        }
    }

}
