package com.graphaware.module.noderank;

import com.graphaware.common.policy.NodeInclusionPolicy;
import com.graphaware.common.policy.RelationshipInclusionPolicy;
import com.graphaware.runtime.policy.all.IncludeAllBusinessNodes;
import com.graphaware.runtime.policy.all.IncludeAllBusinessRelationships;

/**
 * Configuration settings for the {@link NodeRankModule} with fluent interface.
 */
public class NodeRankModuleConfiguration {

    private final String rankPropertyKey;
    private final NodeInclusionPolicy nodeInclusionPolicy;
    private final RelationshipInclusionPolicy relationshipInclusionPolicy;
    private final int maxTopRankNodes;

    /**
     * Retrieves the default {@link NodeRankModuleConfiguration}, which includes all (non-internal) nodes and relationships.
     *
     * @return The default {@link NodeRankModuleConfiguration}
     */
    public static NodeRankModuleConfiguration defaultConfiguration() {
        return new NodeRankModuleConfiguration("nodeRank", IncludeAllBusinessNodes.getInstance(), IncludeAllBusinessRelationships.getInstance(), 10);
    }

    /**
     * Construct a new configuration with the given rank property key.
     *
     * @param rankPropertyKey key of the property written to the ranked nodes.
     * @return new config.
     */
    public NodeRankModuleConfiguration withRankPropertyKey(String rankPropertyKey) {
        return new NodeRankModuleConfiguration(rankPropertyKey, getNodeInclusionPolicy(), getRelationshipInclusionPolicy(), getMaxTopRankNodes());
    }

    /**
     * Construct a new configuration with the given node inclusion policy.
     *
     * @param nodeInclusionPolicy The {@link NodeInclusionPolicy} to use for selecting nodes to include in the rank algorithm.
     * @return new config.
     */
    public NodeRankModuleConfiguration with(NodeInclusionPolicy nodeInclusionPolicy) {
        return new NodeRankModuleConfiguration(getRankPropertyKey(), nodeInclusionPolicy, getRelationshipInclusionPolicy(), getMaxTopRankNodes());
    }

    /**
     * Construct a new configuration with the given node inclusion policy.
     *
     * @param relationshipInclusionPolicy The {@link RelationshipInclusionPolicy} for selecting which relationships to follow when crawling the graph.
     * @return new config.
     */
    public NodeRankModuleConfiguration with(RelationshipInclusionPolicy relationshipInclusionPolicy) {
        return new NodeRankModuleConfiguration(getRankPropertyKey(), getNodeInclusionPolicy(), relationshipInclusionPolicy, getMaxTopRankNodes());
    }

    /**
     * Construct a new configuration with the given maximum number of top ranked nodes to remember.
     *
     * @param maxTopRankNodes to remember.
     * @return new config.
     */
    public NodeRankModuleConfiguration withMaxTopRankNodes(int maxTopRankNodes) {
        return new NodeRankModuleConfiguration(getRankPropertyKey(), getNodeInclusionPolicy(), getRelationshipInclusionPolicy(), maxTopRankNodes);
    }

    /**
     * Constructs a new {@link NodeRankModuleConfiguration} based on the given inclusion strategies.
     *
     * @param rankPropertyKey             name of the property written to the ranked nodes.
     * @param nodeInclusionPolicy         The {@link NodeInclusionPolicy} to use for selecting nodes to include in the rank algorithm.
     * @param relationshipInclusionPolicy The {@link RelationshipInclusionPolicy} for selecting which relationships to follow when crawling the graph.
     * @param maxTopRankNodes             maximum number of top ranked nodes to remember.
     */
    private NodeRankModuleConfiguration(String rankPropertyKey, NodeInclusionPolicy nodeInclusionPolicy, RelationshipInclusionPolicy relationshipInclusionPolicy, int maxTopRankNodes) {
        this.rankPropertyKey = rankPropertyKey;
        this.nodeInclusionPolicy = nodeInclusionPolicy;
        this.relationshipInclusionPolicy = relationshipInclusionPolicy;
        this.maxTopRankNodes = maxTopRankNodes;
    }

    public String getRankPropertyKey() {
        return rankPropertyKey;
    }

    public NodeInclusionPolicy getNodeInclusionPolicy() {
        return nodeInclusionPolicy;
    }

    public RelationshipInclusionPolicy getRelationshipInclusionPolicy() {
        return relationshipInclusionPolicy;
    }

    public int getMaxTopRankNodes() {
        return maxTopRankNodes;
    }
}