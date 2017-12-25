package org.bitbucket.lcleite.desafioandroid.interaction.pullrequest;

/**
 * Created by leandro on 22/12/2017.
 */


public class GetClosedPullRequestsMockInterceptor extends GetPullRequestsMockInterceptor {

    @Override
    protected String getResponseMock() {
        return "[\n" +
                "  {\n" +
                "    \"url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/27965\",\n" +
                "    \"id\": 159884944,\n" +
                "    \"html_url\": \"https://github.com/elastic/elasticsearch/pull/27965\",\n" +
                "    \"diff_url\": \"https://github.com/elastic/elasticsearch/pull/27965.diff\",\n" +
                "    \"patch_url\": \"https://github.com/elastic/elasticsearch/pull/27965.patch\",\n" +
                "    \"issue_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues/27965\",\n" +
                "    \"number\": 27965,\n" +
                "    \"state\": \"closed\",\n" +
                "    \"locked\": false,\n" +
                "    \"title\": \"Non-peer recovery should set the global checkpoint\",\n" +
                "    \"user\": {\n" +
                "      \"login\": \"bleskes\",\n" +
                "      \"id\": 1006375,\n" +
                "      \"avatar_url\": \"https://avatars1.githubusercontent.com/u/1006375?v=4\",\n" +
                "      \"gravatar_id\": \"\",\n" +
                "      \"url\": \"https://api.github.com/users/bleskes\",\n" +
                "      \"html_url\": \"https://github.com/bleskes\",\n" +
                "      \"followers_url\": \"https://api.github.com/users/bleskes/followers\",\n" +
                "      \"following_url\": \"https://api.github.com/users/bleskes/following{/other_user}\",\n" +
                "      \"gists_url\": \"https://api.github.com/users/bleskes/gists{/gist_id}\",\n" +
                "      \"starred_url\": \"https://api.github.com/users/bleskes/starred{/owner}{/repo}\",\n" +
                "      \"subscriptions_url\": \"https://api.github.com/users/bleskes/subscriptions\",\n" +
                "      \"organizations_url\": \"https://api.github.com/users/bleskes/orgs\",\n" +
                "      \"repos_url\": \"https://api.github.com/users/bleskes/repos\",\n" +
                "      \"events_url\": \"https://api.github.com/users/bleskes/events{/privacy}\",\n" +
                "      \"received_events_url\": \"https://api.github.com/users/bleskes/received_events\",\n" +
                "      \"type\": \"User\",\n" +
                "      \"site_admin\": false\n" +
                "    },\n" +
                "    \"body\": \"Non-Peer recoveries should restore the global checkpoint rather than wait for the activation of the primary. This brings us a step closer to a universe where a recovered shard always has a valid global checkpoint. Concretely:\\r\\n\\r\\n1) Recovery from store can read the checkpoint from the translog\\r\\n2) Recovery from local shards and snapshots can set the global checkpoint to the local checkpoint as this is the only copy of the shard.\\r\\n3) Recovery of an empty shard can set it to `NO_OPS_PERFORMED`\\r\\n\\r\\nPeer recoveries will follow but require more work and thus will have their own PR.\\r\\n\\r\\nI also used the moment to clean up `IndexShard`'s api around starting the engine and doing recovery from the translog. The current naming are a relic of the past and don't align with the current naming schemes in the engine.\",\n" +
                "    \"created_at\": \"2017-12-22T15:13:20Z\",\n" +
                "    \"updated_at\": \"2017-12-22T20:40:18Z\",\n" +
                "    \"closed_at\": \"2017-12-22T20:39:14Z\",\n" +
                "    \"merged_at\": \"2017-12-22T20:39:14Z\",\n" +
                "    \"merge_commit_sha\": \"adb49efe17ebf403e8dc6c3d2bcfd13f031200c2\",\n" +
                "    \"assignee\": null,\n" +
                "    \"assignees\": [\n" +
                "\n" +
                "    ],\n" +
                "    \"requested_reviewers\": [\n" +
                "      {\n" +
                "        \"login\": \"dnhatn\",\n" +
                "        \"id\": 13474362,\n" +
                "        \"avatar_url\": \"https://avatars3.githubusercontent.com/u/13474362?v=4\",\n" +
                "        \"gravatar_id\": \"\",\n" +
                "        \"url\": \"https://api.github.com/users/dnhatn\",\n" +
                "        \"html_url\": \"https://github.com/dnhatn\",\n" +
                "        \"followers_url\": \"https://api.github.com/users/dnhatn/followers\",\n" +
                "        \"following_url\": \"https://api.github.com/users/dnhatn/following{/other_user}\",\n" +
                "        \"gists_url\": \"https://api.github.com/users/dnhatn/gists{/gist_id}\",\n" +
                "        \"starred_url\": \"https://api.github.com/users/dnhatn/starred{/owner}{/repo}\",\n" +
                "        \"subscriptions_url\": \"https://api.github.com/users/dnhatn/subscriptions\",\n" +
                "        \"organizations_url\": \"https://api.github.com/users/dnhatn/orgs\",\n" +
                "        \"repos_url\": \"https://api.github.com/users/dnhatn/repos\",\n" +
                "        \"events_url\": \"https://api.github.com/users/dnhatn/events{/privacy}\",\n" +
                "        \"received_events_url\": \"https://api.github.com/users/dnhatn/received_events\",\n" +
                "        \"type\": \"User\",\n" +
                "        \"site_admin\": false\n" +
                "      }\n" +
                "    ],\n" +
                "    \"milestone\": null,\n" +
                "    \"commits_url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/27965/commits\",\n" +
                "    \"review_comments_url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/27965/comments\",\n" +
                "    \"review_comment_url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/comments{/number}\",\n" +
                "    \"comments_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues/27965/comments\",\n" +
                "    \"statuses_url\": \"https://api.github.com/repos/elastic/elasticsearch/statuses/01820f6649054d20881d62938bbc5bc0a4f15f03\",\n" +
                "    \"head\": {\n" +
                "      \"label\": \"bleskes:recovery_set_global_checkpoint_when_creating_translog\",\n" +
                "      \"ref\": \"recovery_set_global_checkpoint_when_creating_translog\",\n" +
                "      \"sha\": \"01820f6649054d20881d62938bbc5bc0a4f15f03\",\n" +
                "      \"user\": {\n" +
                "        \"login\": \"bleskes\",\n" +
                "        \"id\": 1006375,\n" +
                "        \"avatar_url\": \"https://avatars1.githubusercontent.com/u/1006375?v=4\",\n" +
                "        \"gravatar_id\": \"\",\n" +
                "        \"url\": \"https://api.github.com/users/bleskes\",\n" +
                "        \"html_url\": \"https://github.com/bleskes\",\n" +
                "        \"followers_url\": \"https://api.github.com/users/bleskes/followers\",\n" +
                "        \"following_url\": \"https://api.github.com/users/bleskes/following{/other_user}\",\n" +
                "        \"gists_url\": \"https://api.github.com/users/bleskes/gists{/gist_id}\",\n" +
                "        \"starred_url\": \"https://api.github.com/users/bleskes/starred{/owner}{/repo}\",\n" +
                "        \"subscriptions_url\": \"https://api.github.com/users/bleskes/subscriptions\",\n" +
                "        \"organizations_url\": \"https://api.github.com/users/bleskes/orgs\",\n" +
                "        \"repos_url\": \"https://api.github.com/users/bleskes/repos\",\n" +
                "        \"events_url\": \"https://api.github.com/users/bleskes/events{/privacy}\",\n" +
                "        \"received_events_url\": \"https://api.github.com/users/bleskes/received_events\",\n" +
                "        \"type\": \"User\",\n" +
                "        \"site_admin\": false\n" +
                "      },\n" +
                "      \"repo\": {\n" +
                "        \"id\": 9219509,\n" +
                "        \"name\": \"elasticsearch\",\n" +
                "        \"full_name\": \"bleskes/elasticsearch\",\n" +
                "        \"owner\": {\n" +
                "          \"login\": \"bleskes\",\n" +
                "          \"id\": 1006375,\n" +
                "          \"avatar_url\": \"https://avatars1.githubusercontent.com/u/1006375?v=4\",\n" +
                "          \"gravatar_id\": \"\",\n" +
                "          \"url\": \"https://api.github.com/users/bleskes\",\n" +
                "          \"html_url\": \"https://github.com/bleskes\",\n" +
                "          \"followers_url\": \"https://api.github.com/users/bleskes/followers\",\n" +
                "          \"following_url\": \"https://api.github.com/users/bleskes/following{/other_user}\",\n" +
                "          \"gists_url\": \"https://api.github.com/users/bleskes/gists{/gist_id}\",\n" +
                "          \"starred_url\": \"https://api.github.com/users/bleskes/starred{/owner}{/repo}\",\n" +
                "          \"subscriptions_url\": \"https://api.github.com/users/bleskes/subscriptions\",\n" +
                "          \"organizations_url\": \"https://api.github.com/users/bleskes/orgs\",\n" +
                "          \"repos_url\": \"https://api.github.com/users/bleskes/repos\",\n" +
                "          \"events_url\": \"https://api.github.com/users/bleskes/events{/privacy}\",\n" +
                "          \"received_events_url\": \"https://api.github.com/users/bleskes/received_events\",\n" +
                "          \"type\": \"User\",\n" +
                "          \"site_admin\": false\n" +
                "        },\n" +
                "        \"private\": false,\n" +
                "        \"html_url\": \"https://github.com/bleskes/elasticsearch\",\n" +
                "        \"description\": \"Open Source, Distributed, RESTful Search Engine\",\n" +
                "        \"fork\": true,\n" +
                "        \"url\": \"https://api.github.com/repos/bleskes/elasticsearch\",\n" +
                "        \"forks_url\": \"https://api.github.com/repos/bleskes/elasticsearch/forks\",\n" +
                "        \"keys_url\": \"https://api.github.com/repos/bleskes/elasticsearch/keys{/key_id}\",\n" +
                "        \"collaborators_url\": \"https://api.github.com/repos/bleskes/elasticsearch/collaborators{/collaborator}\",\n" +
                "        \"teams_url\": \"https://api.github.com/repos/bleskes/elasticsearch/teams\",\n" +
                "        \"hooks_url\": \"https://api.github.com/repos/bleskes/elasticsearch/hooks\",\n" +
                "        \"issue_events_url\": \"https://api.github.com/repos/bleskes/elasticsearch/issues/events{/number}\",\n" +
                "        \"events_url\": \"https://api.github.com/repos/bleskes/elasticsearch/events\",\n" +
                "        \"assignees_url\": \"https://api.github.com/repos/bleskes/elasticsearch/assignees{/user}\",\n" +
                "        \"branches_url\": \"https://api.github.com/repos/bleskes/elasticsearch/branches{/branch}\",\n" +
                "        \"tags_url\": \"https://api.github.com/repos/bleskes/elasticsearch/tags\",\n" +
                "        \"blobs_url\": \"https://api.github.com/repos/bleskes/elasticsearch/git/blobs{/sha}\",\n" +
                "        \"git_tags_url\": \"https://api.github.com/repos/bleskes/elasticsearch/git/tags{/sha}\",\n" +
                "        \"git_refs_url\": \"https://api.github.com/repos/bleskes/elasticsearch/git/refs{/sha}\",\n" +
                "        \"trees_url\": \"https://api.github.com/repos/bleskes/elasticsearch/git/trees{/sha}\",\n" +
                "        \"statuses_url\": \"https://api.github.com/repos/bleskes/elasticsearch/statuses/{sha}\",\n" +
                "        \"languages_url\": \"https://api.github.com/repos/bleskes/elasticsearch/languages\",\n" +
                "        \"stargazers_url\": \"https://api.github.com/repos/bleskes/elasticsearch/stargazers\",\n" +
                "        \"contributors_url\": \"https://api.github.com/repos/bleskes/elasticsearch/contributors\",\n" +
                "        \"subscribers_url\": \"https://api.github.com/repos/bleskes/elasticsearch/subscribers\",\n" +
                "        \"subscription_url\": \"https://api.github.com/repos/bleskes/elasticsearch/subscription\",\n" +
                "        \"commits_url\": \"https://api.github.com/repos/bleskes/elasticsearch/commits{/sha}\",\n" +
                "        \"git_commits_url\": \"https://api.github.com/repos/bleskes/elasticsearch/git/commits{/sha}\",\n" +
                "        \"comments_url\": \"https://api.github.com/repos/bleskes/elasticsearch/comments{/number}\",\n" +
                "        \"issue_comment_url\": \"https://api.github.com/repos/bleskes/elasticsearch/issues/comments{/number}\",\n" +
                "        \"contents_url\": \"https://api.github.com/repos/bleskes/elasticsearch/contents/{+path}\",\n" +
                "        \"compare_url\": \"https://api.github.com/repos/bleskes/elasticsearch/compare/{base}...{head}\",\n" +
                "        \"merges_url\": \"https://api.github.com/repos/bleskes/elasticsearch/merges\",\n" +
                "        \"archive_url\": \"https://api.github.com/repos/bleskes/elasticsearch/{archive_format}{/ref}\",\n" +
                "        \"downloads_url\": \"https://api.github.com/repos/bleskes/elasticsearch/downloads\",\n" +
                "        \"issues_url\": \"https://api.github.com/repos/bleskes/elasticsearch/issues{/number}\",\n" +
                "        \"pulls_url\": \"https://api.github.com/repos/bleskes/elasticsearch/pulls{/number}\",\n" +
                "        \"milestones_url\": \"https://api.github.com/repos/bleskes/elasticsearch/milestones{/number}\",\n" +
                "        \"notifications_url\": \"https://api.github.com/repos/bleskes/elasticsearch/notifications{?since,all,participating}\",\n" +
                "        \"labels_url\": \"https://api.github.com/repos/bleskes/elasticsearch/labels{/name}\",\n" +
                "        \"releases_url\": \"https://api.github.com/repos/bleskes/elasticsearch/releases{/id}\",\n" +
                "        \"deployments_url\": \"https://api.github.com/repos/bleskes/elasticsearch/deployments\",\n" +
                "        \"created_at\": \"2013-04-04T14:06:17Z\",\n" +
                "        \"updated_at\": \"2015-04-24T10:42:15Z\",\n" +
                "        \"pushed_at\": \"2017-12-22T20:39:17Z\",\n" +
                "        \"git_url\": \"git://github.com/bleskes/elasticsearch.git\",\n" +
                "        \"ssh_url\": \"git@github.com:bleskes/elasticsearch.git\",\n" +
                "        \"clone_url\": \"https://github.com/bleskes/elasticsearch.git\",\n" +
                "        \"svn_url\": \"https://github.com/bleskes/elasticsearch\",\n" +
                "        \"homepage\": \"http://elasticsearch.org\",\n" +
                "        \"size\": 401475,\n" +
                "        \"stargazers_count\": 0,\n" +
                "        \"watchers_count\": 0,\n" +
                "        \"language\": \"Java\",\n" +
                "        \"has_issues\": false,\n" +
                "        \"has_projects\": true,\n" +
                "        \"has_downloads\": true,\n" +
                "        \"has_wiki\": false,\n" +
                "        \"has_pages\": false,\n" +
                "        \"forks_count\": 0,\n" +
                "        \"mirror_url\": null,\n" +
                "        \"archived\": false,\n" +
                "        \"open_issues_count\": 0,\n" +
                "        \"license\": {\n" +
                "          \"key\": \"apache-2.0\",\n" +
                "          \"name\": \"Apache License 2.0\",\n" +
                "          \"spdx_id\": \"Apache-2.0\",\n" +
                "          \"url\": \"https://api.github.com/licenses/apache-2.0\"\n" +
                "        },\n" +
                "        \"forks\": 0,\n" +
                "        \"open_issues\": 0,\n" +
                "        \"watchers\": 0,\n" +
                "        \"default_branch\": \"master\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"base\": {\n" +
                "      \"label\": \"elastic:master\",\n" +
                "      \"ref\": \"master\",\n" +
                "      \"sha\": \"0423155fc6941f964f4694b1188c1238465db277\",\n" +
                "      \"user\": {\n" +
                "        \"login\": \"elastic\",\n" +
                "        \"id\": 6764390,\n" +
                "        \"avatar_url\": \"https://avatars0.githubusercontent.com/u/6764390?v=4\",\n" +
                "        \"gravatar_id\": \"\",\n" +
                "        \"url\": \"https://api.github.com/users/elastic\",\n" +
                "        \"html_url\": \"https://github.com/elastic\",\n" +
                "        \"followers_url\": \"https://api.github.com/users/elastic/followers\",\n" +
                "        \"following_url\": \"https://api.github.com/users/elastic/following{/other_user}\",\n" +
                "        \"gists_url\": \"https://api.github.com/users/elastic/gists{/gist_id}\",\n" +
                "        \"starred_url\": \"https://api.github.com/users/elastic/starred{/owner}{/repo}\",\n" +
                "        \"subscriptions_url\": \"https://api.github.com/users/elastic/subscriptions\",\n" +
                "        \"organizations_url\": \"https://api.github.com/users/elastic/orgs\",\n" +
                "        \"repos_url\": \"https://api.github.com/users/elastic/repos\",\n" +
                "        \"events_url\": \"https://api.github.com/users/elastic/events{/privacy}\",\n" +
                "        \"received_events_url\": \"https://api.github.com/users/elastic/received_events\",\n" +
                "        \"type\": \"Organization\",\n" +
                "        \"site_admin\": false\n" +
                "      },\n" +
                "      \"repo\": {\n" +
                "        \"id\": 507775,\n" +
                "        \"name\": \"elasticsearch\",\n" +
                "        \"full_name\": \"elastic/elasticsearch\",\n" +
                "        \"owner\": {\n" +
                "          \"login\": \"elastic\",\n" +
                "          \"id\": 6764390,\n" +
                "          \"avatar_url\": \"https://avatars0.githubusercontent.com/u/6764390?v=4\",\n" +
                "          \"gravatar_id\": \"\",\n" +
                "          \"url\": \"https://api.github.com/users/elastic\",\n" +
                "          \"html_url\": \"https://github.com/elastic\",\n" +
                "          \"followers_url\": \"https://api.github.com/users/elastic/followers\",\n" +
                "          \"following_url\": \"https://api.github.com/users/elastic/following{/other_user}\",\n" +
                "          \"gists_url\": \"https://api.github.com/users/elastic/gists{/gist_id}\",\n" +
                "          \"starred_url\": \"https://api.github.com/users/elastic/starred{/owner}{/repo}\",\n" +
                "          \"subscriptions_url\": \"https://api.github.com/users/elastic/subscriptions\",\n" +
                "          \"organizations_url\": \"https://api.github.com/users/elastic/orgs\",\n" +
                "          \"repos_url\": \"https://api.github.com/users/elastic/repos\",\n" +
                "          \"events_url\": \"https://api.github.com/users/elastic/events{/privacy}\",\n" +
                "          \"received_events_url\": \"https://api.github.com/users/elastic/received_events\",\n" +
                "          \"type\": \"Organization\",\n" +
                "          \"site_admin\": false\n" +
                "        },\n" +
                "        \"private\": false,\n" +
                "        \"html_url\": \"https://github.com/elastic/elasticsearch\",\n" +
                "        \"description\": \"Open Source, Distributed, RESTful Search Engine\",\n" +
                "        \"fork\": false,\n" +
                "        \"url\": \"https://api.github.com/repos/elastic/elasticsearch\",\n" +
                "        \"forks_url\": \"https://api.github.com/repos/elastic/elasticsearch/forks\",\n" +
                "        \"keys_url\": \"https://api.github.com/repos/elastic/elasticsearch/keys{/key_id}\",\n" +
                "        \"collaborators_url\": \"https://api.github.com/repos/elastic/elasticsearch/collaborators{/collaborator}\",\n" +
                "        \"teams_url\": \"https://api.github.com/repos/elastic/elasticsearch/teams\",\n" +
                "        \"hooks_url\": \"https://api.github.com/repos/elastic/elasticsearch/hooks\",\n" +
                "        \"issue_events_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues/events{/number}\",\n" +
                "        \"events_url\": \"https://api.github.com/repos/elastic/elasticsearch/events\",\n" +
                "        \"assignees_url\": \"https://api.github.com/repos/elastic/elasticsearch/assignees{/user}\",\n" +
                "        \"branches_url\": \"https://api.github.com/repos/elastic/elasticsearch/branches{/branch}\",\n" +
                "        \"tags_url\": \"https://api.github.com/repos/elastic/elasticsearch/tags\",\n" +
                "        \"blobs_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/blobs{/sha}\",\n" +
                "        \"git_tags_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/tags{/sha}\",\n" +
                "        \"git_refs_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/refs{/sha}\",\n" +
                "        \"trees_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/trees{/sha}\",\n" +
                "        \"statuses_url\": \"https://api.github.com/repos/elastic/elasticsearch/statuses/{sha}\",\n" +
                "        \"languages_url\": \"https://api.github.com/repos/elastic/elasticsearch/languages\",\n" +
                "        \"stargazers_url\": \"https://api.github.com/repos/elastic/elasticsearch/stargazers\",\n" +
                "        \"contributors_url\": \"https://api.github.com/repos/elastic/elasticsearch/contributors\",\n" +
                "        \"subscribers_url\": \"https://api.github.com/repos/elastic/elasticsearch/subscribers\",\n" +
                "        \"subscription_url\": \"https://api.github.com/repos/elastic/elasticsearch/subscription\",\n" +
                "        \"commits_url\": \"https://api.github.com/repos/elastic/elasticsearch/commits{/sha}\",\n" +
                "        \"git_commits_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/commits{/sha}\",\n" +
                "        \"comments_url\": \"https://api.github.com/repos/elastic/elasticsearch/comments{/number}\",\n" +
                "        \"issue_comment_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues/comments{/number}\",\n" +
                "        \"contents_url\": \"https://api.github.com/repos/elastic/elasticsearch/contents/{+path}\",\n" +
                "        \"compare_url\": \"https://api.github.com/repos/elastic/elasticsearch/compare/{base}...{head}\",\n" +
                "        \"merges_url\": \"https://api.github.com/repos/elastic/elasticsearch/merges\",\n" +
                "        \"archive_url\": \"https://api.github.com/repos/elastic/elasticsearch/{archive_format}{/ref}\",\n" +
                "        \"downloads_url\": \"https://api.github.com/repos/elastic/elasticsearch/downloads\",\n" +
                "        \"issues_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues{/number}\",\n" +
                "        \"pulls_url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls{/number}\",\n" +
                "        \"milestones_url\": \"https://api.github.com/repos/elastic/elasticsearch/milestones{/number}\",\n" +
                "        \"notifications_url\": \"https://api.github.com/repos/elastic/elasticsearch/notifications{?since,all,participating}\",\n" +
                "        \"labels_url\": \"https://api.github.com/repos/elastic/elasticsearch/labels{/name}\",\n" +
                "        \"releases_url\": \"https://api.github.com/repos/elastic/elasticsearch/releases{/id}\",\n" +
                "        \"deployments_url\": \"https://api.github.com/repos/elastic/elasticsearch/deployments\",\n" +
                "        \"created_at\": \"2010-02-08T13:20:56Z\",\n" +
                "        \"updated_at\": \"2017-12-22T18:17:34Z\",\n" +
                "        \"pushed_at\": \"2017-12-22T21:42:20Z\",\n" +
                "        \"git_url\": \"git://github.com/elastic/elasticsearch.git\",\n" +
                "        \"ssh_url\": \"git@github.com:elastic/elasticsearch.git\",\n" +
                "        \"clone_url\": \"https://github.com/elastic/elasticsearch.git\",\n" +
                "        \"svn_url\": \"https://github.com/elastic/elasticsearch\",\n" +
                "        \"homepage\": \"https://www.elastic.co/products/elasticsearch\",\n" +
                "        \"size\": 380040,\n" +
                "        \"stargazers_count\": 27534,\n" +
                "        \"watchers_count\": 27534,\n" +
                "        \"language\": \"Java\",\n" +
                "        \"has_issues\": true,\n" +
                "        \"has_projects\": true,\n" +
                "        \"has_downloads\": true,\n" +
                "        \"has_wiki\": false,\n" +
                "        \"has_pages\": false,\n" +
                "        \"forks_count\": 9630,\n" +
                "        \"mirror_url\": null,\n" +
                "        \"archived\": false,\n" +
                "        \"open_issues_count\": 1347,\n" +
                "        \"license\": {\n" +
                "          \"key\": \"apache-2.0\",\n" +
                "          \"name\": \"Apache License 2.0\",\n" +
                "          \"spdx_id\": \"Apache-2.0\",\n" +
                "          \"url\": \"https://api.github.com/licenses/apache-2.0\"\n" +
                "        },\n" +
                "        \"forks\": 9630,\n" +
                "        \"open_issues\": 1347,\n" +
                "        \"watchers\": 27534,\n" +
                "        \"default_branch\": \"master\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"_links\": {\n" +
                "      \"self\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/27965\"\n" +
                "      },\n" +
                "      \"html\": {\n" +
                "        \"href\": \"https://github.com/elastic/elasticsearch/pull/27965\"\n" +
                "      },\n" +
                "      \"issue\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/issues/27965\"\n" +
                "      },\n" +
                "      \"comments\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/issues/27965/comments\"\n" +
                "      },\n" +
                "      \"review_comments\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/27965/comments\"\n" +
                "      },\n" +
                "      \"review_comment\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/comments{/number}\"\n" +
                "      },\n" +
                "      \"commits\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/27965/commits\"\n" +
                "      },\n" +
                "      \"statuses\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/statuses/01820f6649054d20881d62938bbc5bc0a4f15f03\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"author_association\": \"MEMBER\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/27962\",\n" +
                "    \"id\": 159850994,\n" +
                "    \"html_url\": \"https://github.com/elastic/elasticsearch/pull/27962\",\n" +
                "    \"diff_url\": \"https://github.com/elastic/elasticsearch/pull/27962.diff\",\n" +
                "    \"patch_url\": \"https://github.com/elastic/elasticsearch/pull/27962.patch\",\n" +
                "    \"issue_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues/27962\",\n" +
                "    \"number\": 27962,\n" +
                "    \"state\": \"closed\",\n" +
                "    \"locked\": false,\n" +
                "    \"title\": \"Also skip Javadoc task for client JARs on JDK 10\",\n" +
                "    \"user\": {\n" +
                "      \"login\": \"jasontedor\",\n" +
                "      \"id\": 4744941,\n" +
                "      \"avatar_url\": \"https://avatars3.githubusercontent.com/u/4744941?v=4\",\n" +
                "      \"gravatar_id\": \"\",\n" +
                "      \"url\": \"https://api.github.com/users/jasontedor\",\n" +
                "      \"html_url\": \"https://github.com/jasontedor\",\n" +
                "      \"followers_url\": \"https://api.github.com/users/jasontedor/followers\",\n" +
                "      \"following_url\": \"https://api.github.com/users/jasontedor/following{/other_user}\",\n" +
                "      \"gists_url\": \"https://api.github.com/users/jasontedor/gists{/gist_id}\",\n" +
                "      \"starred_url\": \"https://api.github.com/users/jasontedor/starred{/owner}{/repo}\",\n" +
                "      \"subscriptions_url\": \"https://api.github.com/users/jasontedor/subscriptions\",\n" +
                "      \"organizations_url\": \"https://api.github.com/users/jasontedor/orgs\",\n" +
                "      \"repos_url\": \"https://api.github.com/users/jasontedor/repos\",\n" +
                "      \"events_url\": \"https://api.github.com/users/jasontedor/events{/privacy}\",\n" +
                "      \"received_events_url\": \"https://api.github.com/users/jasontedor/received_events\",\n" +
                "      \"type\": \"User\",\n" +
                "      \"site_admin\": false\n" +
                "    },\n" +
                "    \"body\": \"We disabled the Javadoc task on JDK 10 due to an apparent bug in Javadoc generation on JDK 10. However, the client JAR task sets up its own Javadoc task for client JARs (because it merely copies the non-client Javadoc JAR). This commit diables that task too, since the Javadocs for the non-client JAR will not exist.\\r\\n\\r\\nCloses #27961\",\n" +
                "    \"created_at\": \"2017-12-22T11:34:03Z\",\n" +
                "    \"updated_at\": \"2017-12-22T12:36:41Z\",\n" +
                "    \"closed_at\": \"2017-12-22T12:34:01Z\",\n" +
                "    \"merged_at\": \"2017-12-22T12:34:01Z\",\n" +
                "    \"merge_commit_sha\": \"0423155fc6941f964f4694b1188c1238465db277\",\n" +
                "    \"assignee\": null,\n" +
                "    \"assignees\": [\n" +
                "\n" +
                "    ],\n" +
                "    \"requested_reviewers\": [\n" +
                "\n" +
                "    ],\n" +
                "    \"milestone\": null,\n" +
                "    \"commits_url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/27962/commits\",\n" +
                "    \"review_comments_url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/27962/comments\",\n" +
                "    \"review_comment_url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/comments{/number}\",\n" +
                "    \"comments_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues/27962/comments\",\n" +
                "    \"statuses_url\": \"https://api.github.com/repos/elastic/elasticsearch/statuses/34a60976625d030e83122617c6bcfe3585fe048c\",\n" +
                "    \"head\": {\n" +
                "      \"label\": \"jasontedor:client-jar-jdk-10\",\n" +
                "      \"ref\": \"client-jar-jdk-10\",\n" +
                "      \"sha\": \"34a60976625d030e83122617c6bcfe3585fe048c\",\n" +
                "      \"user\": {\n" +
                "        \"login\": \"jasontedor\",\n" +
                "        \"id\": 4744941,\n" +
                "        \"avatar_url\": \"https://avatars3.githubusercontent.com/u/4744941?v=4\",\n" +
                "        \"gravatar_id\": \"\",\n" +
                "        \"url\": \"https://api.github.com/users/jasontedor\",\n" +
                "        \"html_url\": \"https://github.com/jasontedor\",\n" +
                "        \"followers_url\": \"https://api.github.com/users/jasontedor/followers\",\n" +
                "        \"following_url\": \"https://api.github.com/users/jasontedor/following{/other_user}\",\n" +
                "        \"gists_url\": \"https://api.github.com/users/jasontedor/gists{/gist_id}\",\n" +
                "        \"starred_url\": \"https://api.github.com/users/jasontedor/starred{/owner}{/repo}\",\n" +
                "        \"subscriptions_url\": \"https://api.github.com/users/jasontedor/subscriptions\",\n" +
                "        \"organizations_url\": \"https://api.github.com/users/jasontedor/orgs\",\n" +
                "        \"repos_url\": \"https://api.github.com/users/jasontedor/repos\",\n" +
                "        \"events_url\": \"https://api.github.com/users/jasontedor/events{/privacy}\",\n" +
                "        \"received_events_url\": \"https://api.github.com/users/jasontedor/received_events\",\n" +
                "        \"type\": \"User\",\n" +
                "        \"site_admin\": false\n" +
                "      },\n" +
                "      \"repo\": {\n" +
                "        \"id\": 71962406,\n" +
                "        \"name\": \"elasticsearch\",\n" +
                "        \"full_name\": \"jasontedor/elasticsearch\",\n" +
                "        \"owner\": {\n" +
                "          \"login\": \"jasontedor\",\n" +
                "          \"id\": 4744941,\n" +
                "          \"avatar_url\": \"https://avatars3.githubusercontent.com/u/4744941?v=4\",\n" +
                "          \"gravatar_id\": \"\",\n" +
                "          \"url\": \"https://api.github.com/users/jasontedor\",\n" +
                "          \"html_url\": \"https://github.com/jasontedor\",\n" +
                "          \"followers_url\": \"https://api.github.com/users/jasontedor/followers\",\n" +
                "          \"following_url\": \"https://api.github.com/users/jasontedor/following{/other_user}\",\n" +
                "          \"gists_url\": \"https://api.github.com/users/jasontedor/gists{/gist_id}\",\n" +
                "          \"starred_url\": \"https://api.github.com/users/jasontedor/starred{/owner}{/repo}\",\n" +
                "          \"subscriptions_url\": \"https://api.github.com/users/jasontedor/subscriptions\",\n" +
                "          \"organizations_url\": \"https://api.github.com/users/jasontedor/orgs\",\n" +
                "          \"repos_url\": \"https://api.github.com/users/jasontedor/repos\",\n" +
                "          \"events_url\": \"https://api.github.com/users/jasontedor/events{/privacy}\",\n" +
                "          \"received_events_url\": \"https://api.github.com/users/jasontedor/received_events\",\n" +
                "          \"type\": \"User\",\n" +
                "          \"site_admin\": false\n" +
                "        },\n" +
                "        \"private\": false,\n" +
                "        \"html_url\": \"https://github.com/jasontedor/elasticsearch\",\n" +
                "        \"description\": \"Open Source, Distributed, RESTful Search Engine\",\n" +
                "        \"fork\": true,\n" +
                "        \"url\": \"https://api.github.com/repos/jasontedor/elasticsearch\",\n" +
                "        \"forks_url\": \"https://api.github.com/repos/jasontedor/elasticsearch/forks\",\n" +
                "        \"keys_url\": \"https://api.github.com/repos/jasontedor/elasticsearch/keys{/key_id}\",\n" +
                "        \"collaborators_url\": \"https://api.github.com/repos/jasontedor/elasticsearch/collaborators{/collaborator}\",\n" +
                "        \"teams_url\": \"https://api.github.com/repos/jasontedor/elasticsearch/teams\",\n" +
                "        \"hooks_url\": \"https://api.github.com/repos/jasontedor/elasticsearch/hooks\",\n" +
                "        \"issue_events_url\": \"https://api.github.com/repos/jasontedor/elasticsearch/issues/events{/number}\",\n" +
                "        \"events_url\": \"https://api.github.com/repos/jasontedor/elasticsearch/events\",\n" +
                "        \"assignees_url\": \"https://api.github.com/repos/jasontedor/elasticsearch/assignees{/user}\",\n" +
                "        \"branches_url\": \"https://api.github.com/repos/jasontedor/elasticsearch/branches{/branch}\",\n" +
                "        \"tags_url\": \"https://api.github.com/repos/jasontedor/elasticsearch/tags\",\n" +
                "        \"blobs_url\": \"https://api.github.com/repos/jasontedor/elasticsearch/git/blobs{/sha}\",\n" +
                "        \"git_tags_url\": \"https://api.github.com/repos/jasontedor/elasticsearch/git/tags{/sha}\",\n" +
                "        \"git_refs_url\": \"https://api.github.com/repos/jasontedor/elasticsearch/git/refs{/sha}\",\n" +
                "        \"trees_url\": \"https://api.github.com/repos/jasontedor/elasticsearch/git/trees{/sha}\",\n" +
                "        \"statuses_url\": \"https://api.github.com/repos/jasontedor/elasticsearch/statuses/{sha}\",\n" +
                "        \"languages_url\": \"https://api.github.com/repos/jasontedor/elasticsearch/languages\",\n" +
                "        \"stargazers_url\": \"https://api.github.com/repos/jasontedor/elasticsearch/stargazers\",\n" +
                "        \"contributors_url\": \"https://api.github.com/repos/jasontedor/elasticsearch/contributors\",\n" +
                "        \"subscribers_url\": \"https://api.github.com/repos/jasontedor/elasticsearch/subscribers\",\n" +
                "        \"subscription_url\": \"https://api.github.com/repos/jasontedor/elasticsearch/subscription\",\n" +
                "        \"commits_url\": \"https://api.github.com/repos/jasontedor/elasticsearch/commits{/sha}\",\n" +
                "        \"git_commits_url\": \"https://api.github.com/repos/jasontedor/elasticsearch/git/commits{/sha}\",\n" +
                "        \"comments_url\": \"https://api.github.com/repos/jasontedor/elasticsearch/comments{/number}\",\n" +
                "        \"issue_comment_url\": \"https://api.github.com/repos/jasontedor/elasticsearch/issues/comments{/number}\",\n" +
                "        \"contents_url\": \"https://api.github.com/repos/jasontedor/elasticsearch/contents/{+path}\",\n" +
                "        \"compare_url\": \"https://api.github.com/repos/jasontedor/elasticsearch/compare/{base}...{head}\",\n" +
                "        \"merges_url\": \"https://api.github.com/repos/jasontedor/elasticsearch/merges\",\n" +
                "        \"archive_url\": \"https://api.github.com/repos/jasontedor/elasticsearch/{archive_format}{/ref}\",\n" +
                "        \"downloads_url\": \"https://api.github.com/repos/jasontedor/elasticsearch/downloads\",\n" +
                "        \"issues_url\": \"https://api.github.com/repos/jasontedor/elasticsearch/issues{/number}\",\n" +
                "        \"pulls_url\": \"https://api.github.com/repos/jasontedor/elasticsearch/pulls{/number}\",\n" +
                "        \"milestones_url\": \"https://api.github.com/repos/jasontedor/elasticsearch/milestones{/number}\",\n" +
                "        \"notifications_url\": \"https://api.github.com/repos/jasontedor/elasticsearch/notifications{?since,all,participating}\",\n" +
                "        \"labels_url\": \"https://api.github.com/repos/jasontedor/elasticsearch/labels{/name}\",\n" +
                "        \"releases_url\": \"https://api.github.com/repos/jasontedor/elasticsearch/releases{/id}\",\n" +
                "        \"deployments_url\": \"https://api.github.com/repos/jasontedor/elasticsearch/deployments\",\n" +
                "        \"created_at\": \"2016-10-26T03:23:35Z\",\n" +
                "        \"updated_at\": \"2016-10-26T03:24:01Z\",\n" +
                "        \"pushed_at\": \"2017-12-22T12:36:41Z\",\n" +
                "        \"git_url\": \"git://github.com/jasontedor/elasticsearch.git\",\n" +
                "        \"ssh_url\": \"git@github.com:jasontedor/elasticsearch.git\",\n" +
                "        \"clone_url\": \"https://github.com/jasontedor/elasticsearch.git\",\n" +
                "        \"svn_url\": \"https://github.com/jasontedor/elasticsearch\",\n" +
                "        \"homepage\": \"https://www.elastic.co/products/elasticsearch\",\n" +
                "        \"size\": 348265,\n" +
                "        \"stargazers_count\": 0,\n" +
                "        \"watchers_count\": 0,\n" +
                "        \"language\": \"Java\",\n" +
                "        \"has_issues\": false,\n" +
                "        \"has_projects\": true,\n" +
                "        \"has_downloads\": true,\n" +
                "        \"has_wiki\": false,\n" +
                "        \"has_pages\": false,\n" +
                "        \"forks_count\": 1,\n" +
                "        \"mirror_url\": null,\n" +
                "        \"archived\": false,\n" +
                "        \"open_issues_count\": 0,\n" +
                "        \"license\": {\n" +
                "          \"key\": \"apache-2.0\",\n" +
                "          \"name\": \"Apache License 2.0\",\n" +
                "          \"spdx_id\": \"Apache-2.0\",\n" +
                "          \"url\": \"https://api.github.com/licenses/apache-2.0\"\n" +
                "        },\n" +
                "        \"forks\": 1,\n" +
                "        \"open_issues\": 0,\n" +
                "        \"watchers\": 0,\n" +
                "        \"default_branch\": \"master\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"base\": {\n" +
                "      \"label\": \"elastic:master\",\n" +
                "      \"ref\": \"master\",\n" +
                "      \"sha\": \"012ea03f544c853da54e97e2e3d1a6cafbd25437\",\n" +
                "      \"user\": {\n" +
                "        \"login\": \"elastic\",\n" +
                "        \"id\": 6764390,\n" +
                "        \"avatar_url\": \"https://avatars0.githubusercontent.com/u/6764390?v=4\",\n" +
                "        \"gravatar_id\": \"\",\n" +
                "        \"url\": \"https://api.github.com/users/elastic\",\n" +
                "        \"html_url\": \"https://github.com/elastic\",\n" +
                "        \"followers_url\": \"https://api.github.com/users/elastic/followers\",\n" +
                "        \"following_url\": \"https://api.github.com/users/elastic/following{/other_user}\",\n" +
                "        \"gists_url\": \"https://api.github.com/users/elastic/gists{/gist_id}\",\n" +
                "        \"starred_url\": \"https://api.github.com/users/elastic/starred{/owner}{/repo}\",\n" +
                "        \"subscriptions_url\": \"https://api.github.com/users/elastic/subscriptions\",\n" +
                "        \"organizations_url\": \"https://api.github.com/users/elastic/orgs\",\n" +
                "        \"repos_url\": \"https://api.github.com/users/elastic/repos\",\n" +
                "        \"events_url\": \"https://api.github.com/users/elastic/events{/privacy}\",\n" +
                "        \"received_events_url\": \"https://api.github.com/users/elastic/received_events\",\n" +
                "        \"type\": \"Organization\",\n" +
                "        \"site_admin\": false\n" +
                "      },\n" +
                "      \"repo\": {\n" +
                "        \"id\": 507775,\n" +
                "        \"name\": \"elasticsearch\",\n" +
                "        \"full_name\": \"elastic/elasticsearch\",\n" +
                "        \"owner\": {\n" +
                "          \"login\": \"elastic\",\n" +
                "          \"id\": 6764390,\n" +
                "          \"avatar_url\": \"https://avatars0.githubusercontent.com/u/6764390?v=4\",\n" +
                "          \"gravatar_id\": \"\",\n" +
                "          \"url\": \"https://api.github.com/users/elastic\",\n" +
                "          \"html_url\": \"https://github.com/elastic\",\n" +
                "          \"followers_url\": \"https://api.github.com/users/elastic/followers\",\n" +
                "          \"following_url\": \"https://api.github.com/users/elastic/following{/other_user}\",\n" +
                "          \"gists_url\": \"https://api.github.com/users/elastic/gists{/gist_id}\",\n" +
                "          \"starred_url\": \"https://api.github.com/users/elastic/starred{/owner}{/repo}\",\n" +
                "          \"subscriptions_url\": \"https://api.github.com/users/elastic/subscriptions\",\n" +
                "          \"organizations_url\": \"https://api.github.com/users/elastic/orgs\",\n" +
                "          \"repos_url\": \"https://api.github.com/users/elastic/repos\",\n" +
                "          \"events_url\": \"https://api.github.com/users/elastic/events{/privacy}\",\n" +
                "          \"received_events_url\": \"https://api.github.com/users/elastic/received_events\",\n" +
                "          \"type\": \"Organization\",\n" +
                "          \"site_admin\": false\n" +
                "        },\n" +
                "        \"private\": false,\n" +
                "        \"html_url\": \"https://github.com/elastic/elasticsearch\",\n" +
                "        \"description\": \"Open Source, Distributed, RESTful Search Engine\",\n" +
                "        \"fork\": false,\n" +
                "        \"url\": \"https://api.github.com/repos/elastic/elasticsearch\",\n" +
                "        \"forks_url\": \"https://api.github.com/repos/elastic/elasticsearch/forks\",\n" +
                "        \"keys_url\": \"https://api.github.com/repos/elastic/elasticsearch/keys{/key_id}\",\n" +
                "        \"collaborators_url\": \"https://api.github.com/repos/elastic/elasticsearch/collaborators{/collaborator}\",\n" +
                "        \"teams_url\": \"https://api.github.com/repos/elastic/elasticsearch/teams\",\n" +
                "        \"hooks_url\": \"https://api.github.com/repos/elastic/elasticsearch/hooks\",\n" +
                "        \"issue_events_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues/events{/number}\",\n" +
                "        \"events_url\": \"https://api.github.com/repos/elastic/elasticsearch/events\",\n" +
                "        \"assignees_url\": \"https://api.github.com/repos/elastic/elasticsearch/assignees{/user}\",\n" +
                "        \"branches_url\": \"https://api.github.com/repos/elastic/elasticsearch/branches{/branch}\",\n" +
                "        \"tags_url\": \"https://api.github.com/repos/elastic/elasticsearch/tags\",\n" +
                "        \"blobs_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/blobs{/sha}\",\n" +
                "        \"git_tags_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/tags{/sha}\",\n" +
                "        \"git_refs_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/refs{/sha}\",\n" +
                "        \"trees_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/trees{/sha}\",\n" +
                "        \"statuses_url\": \"https://api.github.com/repos/elastic/elasticsearch/statuses/{sha}\",\n" +
                "        \"languages_url\": \"https://api.github.com/repos/elastic/elasticsearch/languages\",\n" +
                "        \"stargazers_url\": \"https://api.github.com/repos/elastic/elasticsearch/stargazers\",\n" +
                "        \"contributors_url\": \"https://api.github.com/repos/elastic/elasticsearch/contributors\",\n" +
                "        \"subscribers_url\": \"https://api.github.com/repos/elastic/elasticsearch/subscribers\",\n" +
                "        \"subscription_url\": \"https://api.github.com/repos/elastic/elasticsearch/subscription\",\n" +
                "        \"commits_url\": \"https://api.github.com/repos/elastic/elasticsearch/commits{/sha}\",\n" +
                "        \"git_commits_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/commits{/sha}\",\n" +
                "        \"comments_url\": \"https://api.github.com/repos/elastic/elasticsearch/comments{/number}\",\n" +
                "        \"issue_comment_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues/comments{/number}\",\n" +
                "        \"contents_url\": \"https://api.github.com/repos/elastic/elasticsearch/contents/{+path}\",\n" +
                "        \"compare_url\": \"https://api.github.com/repos/elastic/elasticsearch/compare/{base}...{head}\",\n" +
                "        \"merges_url\": \"https://api.github.com/repos/elastic/elasticsearch/merges\",\n" +
                "        \"archive_url\": \"https://api.github.com/repos/elastic/elasticsearch/{archive_format}{/ref}\",\n" +
                "        \"downloads_url\": \"https://api.github.com/repos/elastic/elasticsearch/downloads\",\n" +
                "        \"issues_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues{/number}\",\n" +
                "        \"pulls_url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls{/number}\",\n" +
                "        \"milestones_url\": \"https://api.github.com/repos/elastic/elasticsearch/milestones{/number}\",\n" +
                "        \"notifications_url\": \"https://api.github.com/repos/elastic/elasticsearch/notifications{?since,all,participating}\",\n" +
                "        \"labels_url\": \"https://api.github.com/repos/elastic/elasticsearch/labels{/name}\",\n" +
                "        \"releases_url\": \"https://api.github.com/repos/elastic/elasticsearch/releases{/id}\",\n" +
                "        \"deployments_url\": \"https://api.github.com/repos/elastic/elasticsearch/deployments\",\n" +
                "        \"created_at\": \"2010-02-08T13:20:56Z\",\n" +
                "        \"updated_at\": \"2017-12-22T18:17:34Z\",\n" +
                "        \"pushed_at\": \"2017-12-22T21:42:20Z\",\n" +
                "        \"git_url\": \"git://github.com/elastic/elasticsearch.git\",\n" +
                "        \"ssh_url\": \"git@github.com:elastic/elasticsearch.git\",\n" +
                "        \"clone_url\": \"https://github.com/elastic/elasticsearch.git\",\n" +
                "        \"svn_url\": \"https://github.com/elastic/elasticsearch\",\n" +
                "        \"homepage\": \"https://www.elastic.co/products/elasticsearch\",\n" +
                "        \"size\": 380040,\n" +
                "        \"stargazers_count\": 27534,\n" +
                "        \"watchers_count\": 27534,\n" +
                "        \"language\": \"Java\",\n" +
                "        \"has_issues\": true,\n" +
                "        \"has_projects\": true,\n" +
                "        \"has_downloads\": true,\n" +
                "        \"has_wiki\": false,\n" +
                "        \"has_pages\": false,\n" +
                "        \"forks_count\": 9630,\n" +
                "        \"mirror_url\": null,\n" +
                "        \"archived\": false,\n" +
                "        \"open_issues_count\": 1347,\n" +
                "        \"license\": {\n" +
                "          \"key\": \"apache-2.0\",\n" +
                "          \"name\": \"Apache License 2.0\",\n" +
                "          \"spdx_id\": \"Apache-2.0\",\n" +
                "          \"url\": \"https://api.github.com/licenses/apache-2.0\"\n" +
                "        },\n" +
                "        \"forks\": 9630,\n" +
                "        \"open_issues\": 1347,\n" +
                "        \"watchers\": 27534,\n" +
                "        \"default_branch\": \"master\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"_links\": {\n" +
                "      \"self\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/27962\"\n" +
                "      },\n" +
                "      \"html\": {\n" +
                "        \"href\": \"https://github.com/elastic/elasticsearch/pull/27962\"\n" +
                "      },\n" +
                "      \"issue\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/issues/27962\"\n" +
                "      },\n" +
                "      \"comments\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/issues/27962/comments\"\n" +
                "      },\n" +
                "      \"review_comments\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/27962/comments\"\n" +
                "      },\n" +
                "      \"review_comment\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/comments{/number}\"\n" +
                "      },\n" +
                "      \"commits\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/27962/commits\"\n" +
                "      },\n" +
                "      \"statuses\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/statuses/34a60976625d030e83122617c6bcfe3585fe048c\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"author_association\": \"MEMBER\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/27959\",\n" +
                "    \"id\": 159839881,\n" +
                "    \"html_url\": \"https://github.com/elastic/elasticsearch/pull/27959\",\n" +
                "    \"diff_url\": \"https://github.com/elastic/elasticsearch/pull/27959.diff\",\n" +
                "    \"patch_url\": \"https://github.com/elastic/elasticsearch/pull/27959.patch\",\n" +
                "    \"issue_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues/27959\",\n" +
                "    \"number\": 27959,\n" +
                "    \"state\": \"closed\",\n" +
                "    \"locked\": false,\n" +
                "    \"title\": \"Tests: Fix packaging tests after attachment plugin upgrade\",\n" +
                "    \"user\": {\n" +
                "      \"login\": \"spinscale\",\n" +
                "      \"id\": 667544,\n" +
                "      \"avatar_url\": \"https://avatars2.githubusercontent.com/u/667544?v=4\",\n" +
                "      \"gravatar_id\": \"\",\n" +
                "      \"url\": \"https://api.github.com/users/spinscale\",\n" +
                "      \"html_url\": \"https://github.com/spinscale\",\n" +
                "      \"followers_url\": \"https://api.github.com/users/spinscale/followers\",\n" +
                "      \"following_url\": \"https://api.github.com/users/spinscale/following{/other_user}\",\n" +
                "      \"gists_url\": \"https://api.github.com/users/spinscale/gists{/gist_id}\",\n" +
                "      \"starred_url\": \"https://api.github.com/users/spinscale/starred{/owner}{/repo}\",\n" +
                "      \"subscriptions_url\": \"https://api.github.com/users/spinscale/subscriptions\",\n" +
                "      \"organizations_url\": \"https://api.github.com/users/spinscale/orgs\",\n" +
                "      \"repos_url\": \"https://api.github.com/users/spinscale/repos\",\n" +
                "      \"events_url\": \"https://api.github.com/users/spinscale/events{/privacy}\",\n" +
                "      \"received_events_url\": \"https://api.github.com/users/spinscale/received_events\",\n" +
                "      \"type\": \"User\",\n" +
                "      \"site_admin\": false\n" +
                "    },\n" +
                "    \"body\": \"The tests explicitely check for the version of some java dependencies\\r\\nand thus needed to be fixed.\\r\\n\\r\\nRelates #27824\",\n" +
                "    \"created_at\": \"2017-12-22T10:24:43Z\",\n" +
                "    \"updated_at\": \"2017-12-22T11:16:18Z\",\n" +
                "    \"closed_at\": \"2017-12-22T11:16:18Z\",\n" +
                "    \"merged_at\": \"2017-12-22T11:16:18Z\",\n" +
                "    \"merge_commit_sha\": \"012ea03f544c853da54e97e2e3d1a6cafbd25437\",\n" +
                "    \"assignee\": null,\n" +
                "    \"assignees\": [\n" +
                "\n" +
                "    ],\n" +
                "    \"requested_reviewers\": [\n" +
                "\n" +
                "    ],\n" +
                "    \"milestone\": null,\n" +
                "    \"commits_url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/27959/commits\",\n" +
                "    \"review_comments_url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/27959/comments\",\n" +
                "    \"review_comment_url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/comments{/number}\",\n" +
                "    \"comments_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues/27959/comments\",\n" +
                "    \"statuses_url\": \"https://api.github.com/repos/elastic/elasticsearch/statuses/b07041b7bdb195dc8e9a3dce66cb77628eec3f11\",\n" +
                "    \"head\": {\n" +
                "      \"label\": \"spinscale:1712-fix-packaging-tests\",\n" +
                "      \"ref\": \"1712-fix-packaging-tests\",\n" +
                "      \"sha\": \"b07041b7bdb195dc8e9a3dce66cb77628eec3f11\",\n" +
                "      \"user\": {\n" +
                "        \"login\": \"spinscale\",\n" +
                "        \"id\": 667544,\n" +
                "        \"avatar_url\": \"https://avatars2.githubusercontent.com/u/667544?v=4\",\n" +
                "        \"gravatar_id\": \"\",\n" +
                "        \"url\": \"https://api.github.com/users/spinscale\",\n" +
                "        \"html_url\": \"https://github.com/spinscale\",\n" +
                "        \"followers_url\": \"https://api.github.com/users/spinscale/followers\",\n" +
                "        \"following_url\": \"https://api.github.com/users/spinscale/following{/other_user}\",\n" +
                "        \"gists_url\": \"https://api.github.com/users/spinscale/gists{/gist_id}\",\n" +
                "        \"starred_url\": \"https://api.github.com/users/spinscale/starred{/owner}{/repo}\",\n" +
                "        \"subscriptions_url\": \"https://api.github.com/users/spinscale/subscriptions\",\n" +
                "        \"organizations_url\": \"https://api.github.com/users/spinscale/orgs\",\n" +
                "        \"repos_url\": \"https://api.github.com/users/spinscale/repos\",\n" +
                "        \"events_url\": \"https://api.github.com/users/spinscale/events{/privacy}\",\n" +
                "        \"received_events_url\": \"https://api.github.com/users/spinscale/received_events\",\n" +
                "        \"type\": \"User\",\n" +
                "        \"site_admin\": false\n" +
                "      },\n" +
                "      \"repo\": {\n" +
                "        \"id\": 8698747,\n" +
                "        \"name\": \"elasticsearch\",\n" +
                "        \"full_name\": \"spinscale/elasticsearch\",\n" +
                "        \"owner\": {\n" +
                "          \"login\": \"spinscale\",\n" +
                "          \"id\": 667544,\n" +
                "          \"avatar_url\": \"https://avatars2.githubusercontent.com/u/667544?v=4\",\n" +
                "          \"gravatar_id\": \"\",\n" +
                "          \"url\": \"https://api.github.com/users/spinscale\",\n" +
                "          \"html_url\": \"https://github.com/spinscale\",\n" +
                "          \"followers_url\": \"https://api.github.com/users/spinscale/followers\",\n" +
                "          \"following_url\": \"https://api.github.com/users/spinscale/following{/other_user}\",\n" +
                "          \"gists_url\": \"https://api.github.com/users/spinscale/gists{/gist_id}\",\n" +
                "          \"starred_url\": \"https://api.github.com/users/spinscale/starred{/owner}{/repo}\",\n" +
                "          \"subscriptions_url\": \"https://api.github.com/users/spinscale/subscriptions\",\n" +
                "          \"organizations_url\": \"https://api.github.com/users/spinscale/orgs\",\n" +
                "          \"repos_url\": \"https://api.github.com/users/spinscale/repos\",\n" +
                "          \"events_url\": \"https://api.github.com/users/spinscale/events{/privacy}\",\n" +
                "          \"received_events_url\": \"https://api.github.com/users/spinscale/received_events\",\n" +
                "          \"type\": \"User\",\n" +
                "          \"site_admin\": false\n" +
                "        },\n" +
                "        \"private\": false,\n" +
                "        \"html_url\": \"https://github.com/spinscale/elasticsearch\",\n" +
                "        \"description\": \"Open Source, Distributed, RESTful Search Engine\",\n" +
                "        \"fork\": true,\n" +
                "        \"url\": \"https://api.github.com/repos/spinscale/elasticsearch\",\n" +
                "        \"forks_url\": \"https://api.github.com/repos/spinscale/elasticsearch/forks\",\n" +
                "        \"keys_url\": \"https://api.github.com/repos/spinscale/elasticsearch/keys{/key_id}\",\n" +
                "        \"collaborators_url\": \"https://api.github.com/repos/spinscale/elasticsearch/collaborators{/collaborator}\",\n" +
                "        \"teams_url\": \"https://api.github.com/repos/spinscale/elasticsearch/teams\",\n" +
                "        \"hooks_url\": \"https://api.github.com/repos/spinscale/elasticsearch/hooks\",\n" +
                "        \"issue_events_url\": \"https://api.github.com/repos/spinscale/elasticsearch/issues/events{/number}\",\n" +
                "        \"events_url\": \"https://api.github.com/repos/spinscale/elasticsearch/events\",\n" +
                "        \"assignees_url\": \"https://api.github.com/repos/spinscale/elasticsearch/assignees{/user}\",\n" +
                "        \"branches_url\": \"https://api.github.com/repos/spinscale/elasticsearch/branches{/branch}\",\n" +
                "        \"tags_url\": \"https://api.github.com/repos/spinscale/elasticsearch/tags\",\n" +
                "        \"blobs_url\": \"https://api.github.com/repos/spinscale/elasticsearch/git/blobs{/sha}\",\n" +
                "        \"git_tags_url\": \"https://api.github.com/repos/spinscale/elasticsearch/git/tags{/sha}\",\n" +
                "        \"git_refs_url\": \"https://api.github.com/repos/spinscale/elasticsearch/git/refs{/sha}\",\n" +
                "        \"trees_url\": \"https://api.github.com/repos/spinscale/elasticsearch/git/trees{/sha}\",\n" +
                "        \"statuses_url\": \"https://api.github.com/repos/spinscale/elasticsearch/statuses/{sha}\",\n" +
                "        \"languages_url\": \"https://api.github.com/repos/spinscale/elasticsearch/languages\",\n" +
                "        \"stargazers_url\": \"https://api.github.com/repos/spinscale/elasticsearch/stargazers\",\n" +
                "        \"contributors_url\": \"https://api.github.com/repos/spinscale/elasticsearch/contributors\",\n" +
                "        \"subscribers_url\": \"https://api.github.com/repos/spinscale/elasticsearch/subscribers\",\n" +
                "        \"subscription_url\": \"https://api.github.com/repos/spinscale/elasticsearch/subscription\",\n" +
                "        \"commits_url\": \"https://api.github.com/repos/spinscale/elasticsearch/commits{/sha}\",\n" +
                "        \"git_commits_url\": \"https://api.github.com/repos/spinscale/elasticsearch/git/commits{/sha}\",\n" +
                "        \"comments_url\": \"https://api.github.com/repos/spinscale/elasticsearch/comments{/number}\",\n" +
                "        \"issue_comment_url\": \"https://api.github.com/repos/spinscale/elasticsearch/issues/comments{/number}\",\n" +
                "        \"contents_url\": \"https://api.github.com/repos/spinscale/elasticsearch/contents/{+path}\",\n" +
                "        \"compare_url\": \"https://api.github.com/repos/spinscale/elasticsearch/compare/{base}...{head}\",\n" +
                "        \"merges_url\": \"https://api.github.com/repos/spinscale/elasticsearch/merges\",\n" +
                "        \"archive_url\": \"https://api.github.com/repos/spinscale/elasticsearch/{archive_format}{/ref}\",\n" +
                "        \"downloads_url\": \"https://api.github.com/repos/spinscale/elasticsearch/downloads\",\n" +
                "        \"issues_url\": \"https://api.github.com/repos/spinscale/elasticsearch/issues{/number}\",\n" +
                "        \"pulls_url\": \"https://api.github.com/repos/spinscale/elasticsearch/pulls{/number}\",\n" +
                "        \"milestones_url\": \"https://api.github.com/repos/spinscale/elasticsearch/milestones{/number}\",\n" +
                "        \"notifications_url\": \"https://api.github.com/repos/spinscale/elasticsearch/notifications{?since,all,participating}\",\n" +
                "        \"labels_url\": \"https://api.github.com/repos/spinscale/elasticsearch/labels{/name}\",\n" +
                "        \"releases_url\": \"https://api.github.com/repos/spinscale/elasticsearch/releases{/id}\",\n" +
                "        \"deployments_url\": \"https://api.github.com/repos/spinscale/elasticsearch/deployments\",\n" +
                "        \"created_at\": \"2013-03-11T07:47:35Z\",\n" +
                "        \"updated_at\": \"2016-06-02T09:49:28Z\",\n" +
                "        \"pushed_at\": \"2017-12-22T10:24:09Z\",\n" +
                "        \"git_url\": \"git://github.com/spinscale/elasticsearch.git\",\n" +
                "        \"ssh_url\": \"git@github.com:spinscale/elasticsearch.git\",\n" +
                "        \"clone_url\": \"https://github.com/spinscale/elasticsearch.git\",\n" +
                "        \"svn_url\": \"https://github.com/spinscale/elasticsearch\",\n" +
                "        \"homepage\": \"http://elasticsearch.org\",\n" +
                "        \"size\": 323417,\n" +
                "        \"stargazers_count\": 3,\n" +
                "        \"watchers_count\": 3,\n" +
                "        \"language\": \"Java\",\n" +
                "        \"has_issues\": false,\n" +
                "        \"has_projects\": true,\n" +
                "        \"has_downloads\": true,\n" +
                "        \"has_wiki\": false,\n" +
                "        \"has_pages\": false,\n" +
                "        \"forks_count\": 4,\n" +
                "        \"mirror_url\": null,\n" +
                "        \"archived\": false,\n" +
                "        \"open_issues_count\": 0,\n" +
                "        \"license\": {\n" +
                "          \"key\": \"apache-2.0\",\n" +
                "          \"name\": \"Apache License 2.0\",\n" +
                "          \"spdx_id\": \"Apache-2.0\",\n" +
                "          \"url\": \"https://api.github.com/licenses/apache-2.0\"\n" +
                "        },\n" +
                "        \"forks\": 4,\n" +
                "        \"open_issues\": 0,\n" +
                "        \"watchers\": 3,\n" +
                "        \"default_branch\": \"master\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"base\": {\n" +
                "      \"label\": \"elastic:master\",\n" +
                "      \"ref\": \"master\",\n" +
                "      \"sha\": \"098f82f086a5d1d06802e0c5ac590330de8c384f\",\n" +
                "      \"user\": {\n" +
                "        \"login\": \"elastic\",\n" +
                "        \"id\": 6764390,\n" +
                "        \"avatar_url\": \"https://avatars0.githubusercontent.com/u/6764390?v=4\",\n" +
                "        \"gravatar_id\": \"\",\n" +
                "        \"url\": \"https://api.github.com/users/elastic\",\n" +
                "        \"html_url\": \"https://github.com/elastic\",\n" +
                "        \"followers_url\": \"https://api.github.com/users/elastic/followers\",\n" +
                "        \"following_url\": \"https://api.github.com/users/elastic/following{/other_user}\",\n" +
                "        \"gists_url\": \"https://api.github.com/users/elastic/gists{/gist_id}\",\n" +
                "        \"starred_url\": \"https://api.github.com/users/elastic/starred{/owner}{/repo}\",\n" +
                "        \"subscriptions_url\": \"https://api.github.com/users/elastic/subscriptions\",\n" +
                "        \"organizations_url\": \"https://api.github.com/users/elastic/orgs\",\n" +
                "        \"repos_url\": \"https://api.github.com/users/elastic/repos\",\n" +
                "        \"events_url\": \"https://api.github.com/users/elastic/events{/privacy}\",\n" +
                "        \"received_events_url\": \"https://api.github.com/users/elastic/received_events\",\n" +
                "        \"type\": \"Organization\",\n" +
                "        \"site_admin\": false\n" +
                "      },\n" +
                "      \"repo\": {\n" +
                "        \"id\": 507775,\n" +
                "        \"name\": \"elasticsearch\",\n" +
                "        \"full_name\": \"elastic/elasticsearch\",\n" +
                "        \"owner\": {\n" +
                "          \"login\": \"elastic\",\n" +
                "          \"id\": 6764390,\n" +
                "          \"avatar_url\": \"https://avatars0.githubusercontent.com/u/6764390?v=4\",\n" +
                "          \"gravatar_id\": \"\",\n" +
                "          \"url\": \"https://api.github.com/users/elastic\",\n" +
                "          \"html_url\": \"https://github.com/elastic\",\n" +
                "          \"followers_url\": \"https://api.github.com/users/elastic/followers\",\n" +
                "          \"following_url\": \"https://api.github.com/users/elastic/following{/other_user}\",\n" +
                "          \"gists_url\": \"https://api.github.com/users/elastic/gists{/gist_id}\",\n" +
                "          \"starred_url\": \"https://api.github.com/users/elastic/starred{/owner}{/repo}\",\n" +
                "          \"subscriptions_url\": \"https://api.github.com/users/elastic/subscriptions\",\n" +
                "          \"organizations_url\": \"https://api.github.com/users/elastic/orgs\",\n" +
                "          \"repos_url\": \"https://api.github.com/users/elastic/repos\",\n" +
                "          \"events_url\": \"https://api.github.com/users/elastic/events{/privacy}\",\n" +
                "          \"received_events_url\": \"https://api.github.com/users/elastic/received_events\",\n" +
                "          \"type\": \"Organization\",\n" +
                "          \"site_admin\": false\n" +
                "        },\n" +
                "        \"private\": false,\n" +
                "        \"html_url\": \"https://github.com/elastic/elasticsearch\",\n" +
                "        \"description\": \"Open Source, Distributed, RESTful Search Engine\",\n" +
                "        \"fork\": false,\n" +
                "        \"url\": \"https://api.github.com/repos/elastic/elasticsearch\",\n" +
                "        \"forks_url\": \"https://api.github.com/repos/elastic/elasticsearch/forks\",\n" +
                "        \"keys_url\": \"https://api.github.com/repos/elastic/elasticsearch/keys{/key_id}\",\n" +
                "        \"collaborators_url\": \"https://api.github.com/repos/elastic/elasticsearch/collaborators{/collaborator}\",\n" +
                "        \"teams_url\": \"https://api.github.com/repos/elastic/elasticsearch/teams\",\n" +
                "        \"hooks_url\": \"https://api.github.com/repos/elastic/elasticsearch/hooks\",\n" +
                "        \"issue_events_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues/events{/number}\",\n" +
                "        \"events_url\": \"https://api.github.com/repos/elastic/elasticsearch/events\",\n" +
                "        \"assignees_url\": \"https://api.github.com/repos/elastic/elasticsearch/assignees{/user}\",\n" +
                "        \"branches_url\": \"https://api.github.com/repos/elastic/elasticsearch/branches{/branch}\",\n" +
                "        \"tags_url\": \"https://api.github.com/repos/elastic/elasticsearch/tags\",\n" +
                "        \"blobs_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/blobs{/sha}\",\n" +
                "        \"git_tags_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/tags{/sha}\",\n" +
                "        \"git_refs_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/refs{/sha}\",\n" +
                "        \"trees_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/trees{/sha}\",\n" +
                "        \"statuses_url\": \"https://api.github.com/repos/elastic/elasticsearch/statuses/{sha}\",\n" +
                "        \"languages_url\": \"https://api.github.com/repos/elastic/elasticsearch/languages\",\n" +
                "        \"stargazers_url\": \"https://api.github.com/repos/elastic/elasticsearch/stargazers\",\n" +
                "        \"contributors_url\": \"https://api.github.com/repos/elastic/elasticsearch/contributors\",\n" +
                "        \"subscribers_url\": \"https://api.github.com/repos/elastic/elasticsearch/subscribers\",\n" +
                "        \"subscription_url\": \"https://api.github.com/repos/elastic/elasticsearch/subscription\",\n" +
                "        \"commits_url\": \"https://api.github.com/repos/elastic/elasticsearch/commits{/sha}\",\n" +
                "        \"git_commits_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/commits{/sha}\",\n" +
                "        \"comments_url\": \"https://api.github.com/repos/elastic/elasticsearch/comments{/number}\",\n" +
                "        \"issue_comment_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues/comments{/number}\",\n" +
                "        \"contents_url\": \"https://api.github.com/repos/elastic/elasticsearch/contents/{+path}\",\n" +
                "        \"compare_url\": \"https://api.github.com/repos/elastic/elasticsearch/compare/{base}...{head}\",\n" +
                "        \"merges_url\": \"https://api.github.com/repos/elastic/elasticsearch/merges\",\n" +
                "        \"archive_url\": \"https://api.github.com/repos/elastic/elasticsearch/{archive_format}{/ref}\",\n" +
                "        \"downloads_url\": \"https://api.github.com/repos/elastic/elasticsearch/downloads\",\n" +
                "        \"issues_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues{/number}\",\n" +
                "        \"pulls_url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls{/number}\",\n" +
                "        \"milestones_url\": \"https://api.github.com/repos/elastic/elasticsearch/milestones{/number}\",\n" +
                "        \"notifications_url\": \"https://api.github.com/repos/elastic/elasticsearch/notifications{?since,all,participating}\",\n" +
                "        \"labels_url\": \"https://api.github.com/repos/elastic/elasticsearch/labels{/name}\",\n" +
                "        \"releases_url\": \"https://api.github.com/repos/elastic/elasticsearch/releases{/id}\",\n" +
                "        \"deployments_url\": \"https://api.github.com/repos/elastic/elasticsearch/deployments\",\n" +
                "        \"created_at\": \"2010-02-08T13:20:56Z\",\n" +
                "        \"updated_at\": \"2017-12-22T18:17:34Z\",\n" +
                "        \"pushed_at\": \"2017-12-22T21:42:20Z\",\n" +
                "        \"git_url\": \"git://github.com/elastic/elasticsearch.git\",\n" +
                "        \"ssh_url\": \"git@github.com:elastic/elasticsearch.git\",\n" +
                "        \"clone_url\": \"https://github.com/elastic/elasticsearch.git\",\n" +
                "        \"svn_url\": \"https://github.com/elastic/elasticsearch\",\n" +
                "        \"homepage\": \"https://www.elastic.co/products/elasticsearch\",\n" +
                "        \"size\": 380040,\n" +
                "        \"stargazers_count\": 27534,\n" +
                "        \"watchers_count\": 27534,\n" +
                "        \"language\": \"Java\",\n" +
                "        \"has_issues\": true,\n" +
                "        \"has_projects\": true,\n" +
                "        \"has_downloads\": true,\n" +
                "        \"has_wiki\": false,\n" +
                "        \"has_pages\": false,\n" +
                "        \"forks_count\": 9630,\n" +
                "        \"mirror_url\": null,\n" +
                "        \"archived\": false,\n" +
                "        \"open_issues_count\": 1347,\n" +
                "        \"license\": {\n" +
                "          \"key\": \"apache-2.0\",\n" +
                "          \"name\": \"Apache License 2.0\",\n" +
                "          \"spdx_id\": \"Apache-2.0\",\n" +
                "          \"url\": \"https://api.github.com/licenses/apache-2.0\"\n" +
                "        },\n" +
                "        \"forks\": 9630,\n" +
                "        \"open_issues\": 1347,\n" +
                "        \"watchers\": 27534,\n" +
                "        \"default_branch\": \"master\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"_links\": {\n" +
                "      \"self\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/27959\"\n" +
                "      },\n" +
                "      \"html\": {\n" +
                "        \"href\": \"https://github.com/elastic/elasticsearch/pull/27959\"\n" +
                "      },\n" +
                "      \"issue\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/issues/27959\"\n" +
                "      },\n" +
                "      \"comments\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/issues/27959/comments\"\n" +
                "      },\n" +
                "      \"review_comments\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/27959/comments\"\n" +
                "      },\n" +
                "      \"review_comment\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/comments{/number}\"\n" +
                "      },\n" +
                "      \"commits\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/27959/commits\"\n" +
                "      },\n" +
                "      \"statuses\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/statuses/b07041b7bdb195dc8e9a3dce66cb77628eec3f11\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"author_association\": \"MEMBER\"\n" +
                "  }\n" +
                "]";
    }

    //TODO: remove it from here
    private String getStateOpenResponseMock() {
        return "[\n" +
                "  {\n" +
                "    \"url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/27968\",\n" +
                "    \"id\": 159927223,\n" +
                "    \"html_url\": \"https://github.com/elastic/elasticsearch/pull/27968\",\n" +
                "    \"diff_url\": \"https://github.com/elastic/elasticsearch/pull/27968.diff\",\n" +
                "    \"patch_url\": \"https://github.com/elastic/elasticsearch/pull/27968.patch\",\n" +
                "    \"issue_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues/27968\",\n" +
                "    \"number\": 27968,\n" +
                "    \"state\": \"open\",\n" +
                "    \"locked\": false,\n" +
                "    \"title\": \"Introduce limit to the number of terms in Terms Query\",\n" +
                "    \"user\": {\n" +
                "      \"login\": \"mayya-sharipova\",\n" +
                "      \"id\": 5738841,\n" +
                "      \"avatar_url\": \"https://avatars1.githubusercontent.com/u/5738841?v=4\",\n" +
                "      \"gravatar_id\": \"\",\n" +
                "      \"url\": \"https://api.github.com/users/mayya-sharipova\",\n" +
                "      \"html_url\": \"https://github.com/mayya-sharipova\",\n" +
                "      \"followers_url\": \"https://api.github.com/users/mayya-sharipova/followers\",\n" +
                "      \"following_url\": \"https://api.github.com/users/mayya-sharipova/following{/other_user}\",\n" +
                "      \"gists_url\": \"https://api.github.com/users/mayya-sharipova/gists{/gist_id}\",\n" +
                "      \"starred_url\": \"https://api.github.com/users/mayya-sharipova/starred{/owner}{/repo}\",\n" +
                "      \"subscriptions_url\": \"https://api.github.com/users/mayya-sharipova/subscriptions\",\n" +
                "      \"organizations_url\": \"https://api.github.com/users/mayya-sharipova/orgs\",\n" +
                "      \"repos_url\": \"https://api.github.com/users/mayya-sharipova/repos\",\n" +
                "      \"events_url\": \"https://api.github.com/users/mayya-sharipova/events{/privacy}\",\n" +
                "      \"received_events_url\": \"https://api.github.com/users/mayya-sharipova/received_events\",\n" +
                "      \"type\": \"User\",\n" +
                "      \"site_admin\": false\n" +
                "    },\n" +
                "    \"body\": \"- Introduce index level settings to control the maximum number of terms\\r\\n    that can be used in a Terms Query\\r\\n- Throw an error if a request exceeds this max number\\r\\n\\r\\nCloses #18829\\r\\n\",\n" +
                "    \"created_at\": \"2017-12-22T20:08:59Z\",\n" +
                "    \"updated_at\": \"2017-12-22T22:29:09Z\",\n" +
                "    \"closed_at\": null,\n" +
                "    \"merged_at\": null,\n" +
                "    \"merge_commit_sha\": \"8c8ee302ad0d1b7dcb10274fb9a659a75be9e3bd\",\n" +
                "    \"assignee\": null,\n" +
                "    \"assignees\": [\n" +
                "\n" +
                "    ],\n" +
                "    \"requested_reviewers\": [\n" +
                "\n" +
                "    ],\n" +
                "    \"milestone\": null,\n" +
                "    \"commits_url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/27968/commits\",\n" +
                "    \"review_comments_url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/27968/comments\",\n" +
                "    \"review_comment_url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/comments{/number}\",\n" +
                "    \"comments_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues/27968/comments\",\n" +
                "    \"statuses_url\": \"https://api.github.com/repos/elastic/elasticsearch/statuses/5bf40e22854eb7677fe030e378d4ddd93b8e50d9\",\n" +
                "    \"head\": {\n" +
                "      \"label\": \"mayya-sharipova:limit-terms-count\",\n" +
                "      \"ref\": \"limit-terms-count\",\n" +
                "      \"sha\": \"5bf40e22854eb7677fe030e378d4ddd93b8e50d9\",\n" +
                "      \"user\": {\n" +
                "        \"login\": \"mayya-sharipova\",\n" +
                "        \"id\": 5738841,\n" +
                "        \"avatar_url\": \"https://avatars1.githubusercontent.com/u/5738841?v=4\",\n" +
                "        \"gravatar_id\": \"\",\n" +
                "        \"url\": \"https://api.github.com/users/mayya-sharipova\",\n" +
                "        \"html_url\": \"https://github.com/mayya-sharipova\",\n" +
                "        \"followers_url\": \"https://api.github.com/users/mayya-sharipova/followers\",\n" +
                "        \"following_url\": \"https://api.github.com/users/mayya-sharipova/following{/other_user}\",\n" +
                "        \"gists_url\": \"https://api.github.com/users/mayya-sharipova/gists{/gist_id}\",\n" +
                "        \"starred_url\": \"https://api.github.com/users/mayya-sharipova/starred{/owner}{/repo}\",\n" +
                "        \"subscriptions_url\": \"https://api.github.com/users/mayya-sharipova/subscriptions\",\n" +
                "        \"organizations_url\": \"https://api.github.com/users/mayya-sharipova/orgs\",\n" +
                "        \"repos_url\": \"https://api.github.com/users/mayya-sharipova/repos\",\n" +
                "        \"events_url\": \"https://api.github.com/users/mayya-sharipova/events{/privacy}\",\n" +
                "        \"received_events_url\": \"https://api.github.com/users/mayya-sharipova/received_events\",\n" +
                "        \"type\": \"User\",\n" +
                "        \"site_admin\": false\n" +
                "      },\n" +
                "      \"repo\": {\n" +
                "        \"id\": 106333957,\n" +
                "        \"name\": \"elasticsearch\",\n" +
                "        \"full_name\": \"mayya-sharipova/elasticsearch\",\n" +
                "        \"owner\": {\n" +
                "          \"login\": \"mayya-sharipova\",\n" +
                "          \"id\": 5738841,\n" +
                "          \"avatar_url\": \"https://avatars1.githubusercontent.com/u/5738841?v=4\",\n" +
                "          \"gravatar_id\": \"\",\n" +
                "          \"url\": \"https://api.github.com/users/mayya-sharipova\",\n" +
                "          \"html_url\": \"https://github.com/mayya-sharipova\",\n" +
                "          \"followers_url\": \"https://api.github.com/users/mayya-sharipova/followers\",\n" +
                "          \"following_url\": \"https://api.github.com/users/mayya-sharipova/following{/other_user}\",\n" +
                "          \"gists_url\": \"https://api.github.com/users/mayya-sharipova/gists{/gist_id}\",\n" +
                "          \"starred_url\": \"https://api.github.com/users/mayya-sharipova/starred{/owner}{/repo}\",\n" +
                "          \"subscriptions_url\": \"https://api.github.com/users/mayya-sharipova/subscriptions\",\n" +
                "          \"organizations_url\": \"https://api.github.com/users/mayya-sharipova/orgs\",\n" +
                "          \"repos_url\": \"https://api.github.com/users/mayya-sharipova/repos\",\n" +
                "          \"events_url\": \"https://api.github.com/users/mayya-sharipova/events{/privacy}\",\n" +
                "          \"received_events_url\": \"https://api.github.com/users/mayya-sharipova/received_events\",\n" +
                "          \"type\": \"User\",\n" +
                "          \"site_admin\": false\n" +
                "        },\n" +
                "        \"private\": false,\n" +
                "        \"html_url\": \"https://github.com/mayya-sharipova/elasticsearch\",\n" +
                "        \"description\": \"Open Source, Distributed, RESTful Search Engine\",\n" +
                "        \"fork\": true,\n" +
                "        \"url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch\",\n" +
                "        \"forks_url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch/forks\",\n" +
                "        \"keys_url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch/keys{/key_id}\",\n" +
                "        \"collaborators_url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch/collaborators{/collaborator}\",\n" +
                "        \"teams_url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch/teams\",\n" +
                "        \"hooks_url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch/hooks\",\n" +
                "        \"issue_events_url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch/issues/events{/number}\",\n" +
                "        \"events_url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch/events\",\n" +
                "        \"assignees_url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch/assignees{/user}\",\n" +
                "        \"branches_url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch/branches{/branch}\",\n" +
                "        \"tags_url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch/tags\",\n" +
                "        \"blobs_url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch/git/blobs{/sha}\",\n" +
                "        \"git_tags_url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch/git/tags{/sha}\",\n" +
                "        \"git_refs_url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch/git/refs{/sha}\",\n" +
                "        \"trees_url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch/git/trees{/sha}\",\n" +
                "        \"statuses_url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch/statuses/{sha}\",\n" +
                "        \"languages_url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch/languages\",\n" +
                "        \"stargazers_url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch/stargazers\",\n" +
                "        \"contributors_url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch/contributors\",\n" +
                "        \"subscribers_url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch/subscribers\",\n" +
                "        \"subscription_url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch/subscription\",\n" +
                "        \"commits_url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch/commits{/sha}\",\n" +
                "        \"git_commits_url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch/git/commits{/sha}\",\n" +
                "        \"comments_url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch/comments{/number}\",\n" +
                "        \"issue_comment_url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch/issues/comments{/number}\",\n" +
                "        \"contents_url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch/contents/{+path}\",\n" +
                "        \"compare_url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch/compare/{base}...{head}\",\n" +
                "        \"merges_url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch/merges\",\n" +
                "        \"archive_url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch/{archive_format}{/ref}\",\n" +
                "        \"downloads_url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch/downloads\",\n" +
                "        \"issues_url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch/issues{/number}\",\n" +
                "        \"pulls_url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch/pulls{/number}\",\n" +
                "        \"milestones_url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch/milestones{/number}\",\n" +
                "        \"notifications_url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch/notifications{?since,all,participating}\",\n" +
                "        \"labels_url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch/labels{/name}\",\n" +
                "        \"releases_url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch/releases{/id}\",\n" +
                "        \"deployments_url\": \"https://api.github.com/repos/mayya-sharipova/elasticsearch/deployments\",\n" +
                "        \"created_at\": \"2017-10-09T20:50:06Z\",\n" +
                "        \"updated_at\": \"2017-10-09T20:50:45Z\",\n" +
                "        \"pushed_at\": \"2017-12-22T19:53:26Z\",\n" +
                "        \"git_url\": \"git://github.com/mayya-sharipova/elasticsearch.git\",\n" +
                "        \"ssh_url\": \"git@github.com:mayya-sharipova/elasticsearch.git\",\n" +
                "        \"clone_url\": \"https://github.com/mayya-sharipova/elasticsearch.git\",\n" +
                "        \"svn_url\": \"https://github.com/mayya-sharipova/elasticsearch\",\n" +
                "        \"homepage\": \"https://www.elastic.co/products/elasticsearch\",\n" +
                "        \"size\": 376774,\n" +
                "        \"stargazers_count\": 0,\n" +
                "        \"watchers_count\": 0,\n" +
                "        \"language\": \"Java\",\n" +
                "        \"has_issues\": false,\n" +
                "        \"has_projects\": true,\n" +
                "        \"has_downloads\": true,\n" +
                "        \"has_wiki\": false,\n" +
                "        \"has_pages\": false,\n" +
                "        \"forks_count\": 0,\n" +
                "        \"mirror_url\": null,\n" +
                "        \"archived\": false,\n" +
                "        \"open_issues_count\": 0,\n" +
                "        \"license\": {\n" +
                "          \"key\": \"apache-2.0\",\n" +
                "          \"name\": \"Apache License 2.0\",\n" +
                "          \"spdx_id\": \"Apache-2.0\",\n" +
                "          \"url\": \"https://api.github.com/licenses/apache-2.0\"\n" +
                "        },\n" +
                "        \"forks\": 0,\n" +
                "        \"open_issues\": 0,\n" +
                "        \"watchers\": 0,\n" +
                "        \"default_branch\": \"master\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"base\": {\n" +
                "      \"label\": \"elastic:master\",\n" +
                "      \"ref\": \"master\",\n" +
                "      \"sha\": \"6435928c4ff59c6005c438edab8ec43c2587ecad\",\n" +
                "      \"user\": {\n" +
                "        \"login\": \"elastic\",\n" +
                "        \"id\": 6764390,\n" +
                "        \"avatar_url\": \"https://avatars0.githubusercontent.com/u/6764390?v=4\",\n" +
                "        \"gravatar_id\": \"\",\n" +
                "        \"url\": \"https://api.github.com/users/elastic\",\n" +
                "        \"html_url\": \"https://github.com/elastic\",\n" +
                "        \"followers_url\": \"https://api.github.com/users/elastic/followers\",\n" +
                "        \"following_url\": \"https://api.github.com/users/elastic/following{/other_user}\",\n" +
                "        \"gists_url\": \"https://api.github.com/users/elastic/gists{/gist_id}\",\n" +
                "        \"starred_url\": \"https://api.github.com/users/elastic/starred{/owner}{/repo}\",\n" +
                "        \"subscriptions_url\": \"https://api.github.com/users/elastic/subscriptions\",\n" +
                "        \"organizations_url\": \"https://api.github.com/users/elastic/orgs\",\n" +
                "        \"repos_url\": \"https://api.github.com/users/elastic/repos\",\n" +
                "        \"events_url\": \"https://api.github.com/users/elastic/events{/privacy}\",\n" +
                "        \"received_events_url\": \"https://api.github.com/users/elastic/received_events\",\n" +
                "        \"type\": \"Organization\",\n" +
                "        \"site_admin\": false\n" +
                "      },\n" +
                "      \"repo\": {\n" +
                "        \"id\": 507775,\n" +
                "        \"name\": \"elasticsearch\",\n" +
                "        \"full_name\": \"elastic/elasticsearch\",\n" +
                "        \"owner\": {\n" +
                "          \"login\": \"elastic\",\n" +
                "          \"id\": 6764390,\n" +
                "          \"avatar_url\": \"https://avatars0.githubusercontent.com/u/6764390?v=4\",\n" +
                "          \"gravatar_id\": \"\",\n" +
                "          \"url\": \"https://api.github.com/users/elastic\",\n" +
                "          \"html_url\": \"https://github.com/elastic\",\n" +
                "          \"followers_url\": \"https://api.github.com/users/elastic/followers\",\n" +
                "          \"following_url\": \"https://api.github.com/users/elastic/following{/other_user}\",\n" +
                "          \"gists_url\": \"https://api.github.com/users/elastic/gists{/gist_id}\",\n" +
                "          \"starred_url\": \"https://api.github.com/users/elastic/starred{/owner}{/repo}\",\n" +
                "          \"subscriptions_url\": \"https://api.github.com/users/elastic/subscriptions\",\n" +
                "          \"organizations_url\": \"https://api.github.com/users/elastic/orgs\",\n" +
                "          \"repos_url\": \"https://api.github.com/users/elastic/repos\",\n" +
                "          \"events_url\": \"https://api.github.com/users/elastic/events{/privacy}\",\n" +
                "          \"received_events_url\": \"https://api.github.com/users/elastic/received_events\",\n" +
                "          \"type\": \"Organization\",\n" +
                "          \"site_admin\": false\n" +
                "        },\n" +
                "        \"private\": false,\n" +
                "        \"html_url\": \"https://github.com/elastic/elasticsearch\",\n" +
                "        \"description\": \"Open Source, Distributed, RESTful Search Engine\",\n" +
                "        \"fork\": false,\n" +
                "        \"url\": \"https://api.github.com/repos/elastic/elasticsearch\",\n" +
                "        \"forks_url\": \"https://api.github.com/repos/elastic/elasticsearch/forks\",\n" +
                "        \"keys_url\": \"https://api.github.com/repos/elastic/elasticsearch/keys{/key_id}\",\n" +
                "        \"collaborators_url\": \"https://api.github.com/repos/elastic/elasticsearch/collaborators{/collaborator}\",\n" +
                "        \"teams_url\": \"https://api.github.com/repos/elastic/elasticsearch/teams\",\n" +
                "        \"hooks_url\": \"https://api.github.com/repos/elastic/elasticsearch/hooks\",\n" +
                "        \"issue_events_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues/events{/number}\",\n" +
                "        \"events_url\": \"https://api.github.com/repos/elastic/elasticsearch/events\",\n" +
                "        \"assignees_url\": \"https://api.github.com/repos/elastic/elasticsearch/assignees{/user}\",\n" +
                "        \"branches_url\": \"https://api.github.com/repos/elastic/elasticsearch/branches{/branch}\",\n" +
                "        \"tags_url\": \"https://api.github.com/repos/elastic/elasticsearch/tags\",\n" +
                "        \"blobs_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/blobs{/sha}\",\n" +
                "        \"git_tags_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/tags{/sha}\",\n" +
                "        \"git_refs_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/refs{/sha}\",\n" +
                "        \"trees_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/trees{/sha}\",\n" +
                "        \"statuses_url\": \"https://api.github.com/repos/elastic/elasticsearch/statuses/{sha}\",\n" +
                "        \"languages_url\": \"https://api.github.com/repos/elastic/elasticsearch/languages\",\n" +
                "        \"stargazers_url\": \"https://api.github.com/repos/elastic/elasticsearch/stargazers\",\n" +
                "        \"contributors_url\": \"https://api.github.com/repos/elastic/elasticsearch/contributors\",\n" +
                "        \"subscribers_url\": \"https://api.github.com/repos/elastic/elasticsearch/subscribers\",\n" +
                "        \"subscription_url\": \"https://api.github.com/repos/elastic/elasticsearch/subscription\",\n" +
                "        \"commits_url\": \"https://api.github.com/repos/elastic/elasticsearch/commits{/sha}\",\n" +
                "        \"git_commits_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/commits{/sha}\",\n" +
                "        \"comments_url\": \"https://api.github.com/repos/elastic/elasticsearch/comments{/number}\",\n" +
                "        \"issue_comment_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues/comments{/number}\",\n" +
                "        \"contents_url\": \"https://api.github.com/repos/elastic/elasticsearch/contents/{+path}\",\n" +
                "        \"compare_url\": \"https://api.github.com/repos/elastic/elasticsearch/compare/{base}...{head}\",\n" +
                "        \"merges_url\": \"https://api.github.com/repos/elastic/elasticsearch/merges\",\n" +
                "        \"archive_url\": \"https://api.github.com/repos/elastic/elasticsearch/{archive_format}{/ref}\",\n" +
                "        \"downloads_url\": \"https://api.github.com/repos/elastic/elasticsearch/downloads\",\n" +
                "        \"issues_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues{/number}\",\n" +
                "        \"pulls_url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls{/number}\",\n" +
                "        \"milestones_url\": \"https://api.github.com/repos/elastic/elasticsearch/milestones{/number}\",\n" +
                "        \"notifications_url\": \"https://api.github.com/repos/elastic/elasticsearch/notifications{?since,all,participating}\",\n" +
                "        \"labels_url\": \"https://api.github.com/repos/elastic/elasticsearch/labels{/name}\",\n" +
                "        \"releases_url\": \"https://api.github.com/repos/elastic/elasticsearch/releases{/id}\",\n" +
                "        \"deployments_url\": \"https://api.github.com/repos/elastic/elasticsearch/deployments\",\n" +
                "        \"created_at\": \"2010-02-08T13:20:56Z\",\n" +
                "        \"updated_at\": \"2017-12-22T18:17:34Z\",\n" +
                "        \"pushed_at\": \"2017-12-22T21:42:20Z\",\n" +
                "        \"git_url\": \"git://github.com/elastic/elasticsearch.git\",\n" +
                "        \"ssh_url\": \"git@github.com:elastic/elasticsearch.git\",\n" +
                "        \"clone_url\": \"https://github.com/elastic/elasticsearch.git\",\n" +
                "        \"svn_url\": \"https://github.com/elastic/elasticsearch\",\n" +
                "        \"homepage\": \"https://www.elastic.co/products/elasticsearch\",\n" +
                "        \"size\": 380040,\n" +
                "        \"stargazers_count\": 27534,\n" +
                "        \"watchers_count\": 27534,\n" +
                "        \"language\": \"Java\",\n" +
                "        \"has_issues\": true,\n" +
                "        \"has_projects\": true,\n" +
                "        \"has_downloads\": true,\n" +
                "        \"has_wiki\": false,\n" +
                "        \"has_pages\": false,\n" +
                "        \"forks_count\": 9630,\n" +
                "        \"mirror_url\": null,\n" +
                "        \"archived\": false,\n" +
                "        \"open_issues_count\": 1347,\n" +
                "        \"license\": {\n" +
                "          \"key\": \"apache-2.0\",\n" +
                "          \"name\": \"Apache License 2.0\",\n" +
                "          \"spdx_id\": \"Apache-2.0\",\n" +
                "          \"url\": \"https://api.github.com/licenses/apache-2.0\"\n" +
                "        },\n" +
                "        \"forks\": 9630,\n" +
                "        \"open_issues\": 1347,\n" +
                "        \"watchers\": 27534,\n" +
                "        \"default_branch\": \"master\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"_links\": {\n" +
                "      \"self\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/27968\"\n" +
                "      },\n" +
                "      \"html\": {\n" +
                "        \"href\": \"https://github.com/elastic/elasticsearch/pull/27968\"\n" +
                "      },\n" +
                "      \"issue\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/issues/27968\"\n" +
                "      },\n" +
                "      \"comments\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/issues/27968/comments\"\n" +
                "      },\n" +
                "      \"review_comments\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/27968/comments\"\n" +
                "      },\n" +
                "      \"review_comment\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/comments{/number}\"\n" +
                "      },\n" +
                "      \"commits\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/27968/commits\"\n" +
                "      },\n" +
                "      \"statuses\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/statuses/5bf40e22854eb7677fe030e378d4ddd93b8e50d9\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"author_association\": \"CONTRIBUTOR\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/27967\",\n" +
                "    \"id\": 159921647,\n" +
                "    \"html_url\": \"https://github.com/elastic/elasticsearch/pull/27967\",\n" +
                "    \"diff_url\": \"https://github.com/elastic/elasticsearch/pull/27967.diff\",\n" +
                "    \"patch_url\": \"https://github.com/elastic/elasticsearch/pull/27967.patch\",\n" +
                "    \"issue_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues/27967\",\n" +
                "    \"number\": 27967,\n" +
                "    \"state\": \"open\",\n" +
                "    \"locked\": false,\n" +
                "    \"title\": \"Use the determinant formula for calculating the orientation of a polygon\",\n" +
                "    \"user\": {\n" +
                "      \"login\": \"DaveCTurner\",\n" +
                "      \"id\": 5058284,\n" +
                "      \"avatar_url\": \"https://avatars3.githubusercontent.com/u/5058284?v=4\",\n" +
                "      \"gravatar_id\": \"\",\n" +
                "      \"url\": \"https://api.github.com/users/DaveCTurner\",\n" +
                "      \"html_url\": \"https://github.com/DaveCTurner\",\n" +
                "      \"followers_url\": \"https://api.github.com/users/DaveCTurner/followers\",\n" +
                "      \"following_url\": \"https://api.github.com/users/DaveCTurner/following{/other_user}\",\n" +
                "      \"gists_url\": \"https://api.github.com/users/DaveCTurner/gists{/gist_id}\",\n" +
                "      \"starred_url\": \"https://api.github.com/users/DaveCTurner/starred{/owner}{/repo}\",\n" +
                "      \"subscriptions_url\": \"https://api.github.com/users/DaveCTurner/subscriptions\",\n" +
                "      \"organizations_url\": \"https://api.github.com/users/DaveCTurner/orgs\",\n" +
                "      \"repos_url\": \"https://api.github.com/users/DaveCTurner/repos\",\n" +
                "      \"events_url\": \"https://api.github.com/users/DaveCTurner/events{/privacy}\",\n" +
                "      \"received_events_url\": \"https://api.github.com/users/DaveCTurner/received_events\",\n" +
                "      \"type\": \"User\",\n" +
                "      \"site_admin\": false\n" +
                "    },\n" +
                "    \"body\": \"The method for working out whether a polygon is clockwise or anticlockwise is mostly correct but doesn't work in some rare cases such as the included test case. This PR changes it to determine the orientation from the direction of the cross product of two of the edges of the polygon at a point on its convex hull, which should work more reliably.\",\n" +
                "    \"created_at\": \"2017-12-22T19:24:44Z\",\n" +
                "    \"updated_at\": \"2017-12-22T19:24:45Z\",\n" +
                "    \"closed_at\": null,\n" +
                "    \"merged_at\": null,\n" +
                "    \"merge_commit_sha\": \"f38f20503e98999dbdd1978f9e23557cf4a7a925\",\n" +
                "    \"assignee\": null,\n" +
                "    \"assignees\": [\n" +
                "\n" +
                "    ],\n" +
                "    \"requested_reviewers\": [\n" +
                "      {\n" +
                "        \"login\": \"nknize\",\n" +
                "        \"id\": 830187,\n" +
                "        \"avatar_url\": \"https://avatars3.githubusercontent.com/u/830187?v=4\",\n" +
                "        \"gravatar_id\": \"\",\n" +
                "        \"url\": \"https://api.github.com/users/nknize\",\n" +
                "        \"html_url\": \"https://github.com/nknize\",\n" +
                "        \"followers_url\": \"https://api.github.com/users/nknize/followers\",\n" +
                "        \"following_url\": \"https://api.github.com/users/nknize/following{/other_user}\",\n" +
                "        \"gists_url\": \"https://api.github.com/users/nknize/gists{/gist_id}\",\n" +
                "        \"starred_url\": \"https://api.github.com/users/nknize/starred{/owner}{/repo}\",\n" +
                "        \"subscriptions_url\": \"https://api.github.com/users/nknize/subscriptions\",\n" +
                "        \"organizations_url\": \"https://api.github.com/users/nknize/orgs\",\n" +
                "        \"repos_url\": \"https://api.github.com/users/nknize/repos\",\n" +
                "        \"events_url\": \"https://api.github.com/users/nknize/events{/privacy}\",\n" +
                "        \"received_events_url\": \"https://api.github.com/users/nknize/received_events\",\n" +
                "        \"type\": \"User\",\n" +
                "        \"site_admin\": false\n" +
                "      }\n" +
                "    ],\n" +
                "    \"milestone\": null,\n" +
                "    \"commits_url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/27967/commits\",\n" +
                "    \"review_comments_url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/27967/comments\",\n" +
                "    \"review_comment_url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/comments{/number}\",\n" +
                "    \"comments_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues/27967/comments\",\n" +
                "    \"statuses_url\": \"https://api.github.com/repos/elastic/elasticsearch/statuses/bcfb796b6884651f5761b2cfb257fa70175b8d47\",\n" +
                "    \"head\": {\n" +
                "      \"label\": \"DaveCTurner:2017-12-22-orientation-bug\",\n" +
                "      \"ref\": \"2017-12-22-orientation-bug\",\n" +
                "      \"sha\": \"bcfb796b6884651f5761b2cfb257fa70175b8d47\",\n" +
                "      \"user\": {\n" +
                "        \"login\": \"DaveCTurner\",\n" +
                "        \"id\": 5058284,\n" +
                "        \"avatar_url\": \"https://avatars3.githubusercontent.com/u/5058284?v=4\",\n" +
                "        \"gravatar_id\": \"\",\n" +
                "        \"url\": \"https://api.github.com/users/DaveCTurner\",\n" +
                "        \"html_url\": \"https://github.com/DaveCTurner\",\n" +
                "        \"followers_url\": \"https://api.github.com/users/DaveCTurner/followers\",\n" +
                "        \"following_url\": \"https://api.github.com/users/DaveCTurner/following{/other_user}\",\n" +
                "        \"gists_url\": \"https://api.github.com/users/DaveCTurner/gists{/gist_id}\",\n" +
                "        \"starred_url\": \"https://api.github.com/users/DaveCTurner/starred{/owner}{/repo}\",\n" +
                "        \"subscriptions_url\": \"https://api.github.com/users/DaveCTurner/subscriptions\",\n" +
                "        \"organizations_url\": \"https://api.github.com/users/DaveCTurner/orgs\",\n" +
                "        \"repos_url\": \"https://api.github.com/users/DaveCTurner/repos\",\n" +
                "        \"events_url\": \"https://api.github.com/users/DaveCTurner/events{/privacy}\",\n" +
                "        \"received_events_url\": \"https://api.github.com/users/DaveCTurner/received_events\",\n" +
                "        \"type\": \"User\",\n" +
                "        \"site_admin\": false\n" +
                "      },\n" +
                "      \"repo\": {\n" +
                "        \"id\": 104302209,\n" +
                "        \"name\": \"elasticsearch\",\n" +
                "        \"full_name\": \"DaveCTurner/elasticsearch\",\n" +
                "        \"owner\": {\n" +
                "          \"login\": \"DaveCTurner\",\n" +
                "          \"id\": 5058284,\n" +
                "          \"avatar_url\": \"https://avatars3.githubusercontent.com/u/5058284?v=4\",\n" +
                "          \"gravatar_id\": \"\",\n" +
                "          \"url\": \"https://api.github.com/users/DaveCTurner\",\n" +
                "          \"html_url\": \"https://github.com/DaveCTurner\",\n" +
                "          \"followers_url\": \"https://api.github.com/users/DaveCTurner/followers\",\n" +
                "          \"following_url\": \"https://api.github.com/users/DaveCTurner/following{/other_user}\",\n" +
                "          \"gists_url\": \"https://api.github.com/users/DaveCTurner/gists{/gist_id}\",\n" +
                "          \"starred_url\": \"https://api.github.com/users/DaveCTurner/starred{/owner}{/repo}\",\n" +
                "          \"subscriptions_url\": \"https://api.github.com/users/DaveCTurner/subscriptions\",\n" +
                "          \"organizations_url\": \"https://api.github.com/users/DaveCTurner/orgs\",\n" +
                "          \"repos_url\": \"https://api.github.com/users/DaveCTurner/repos\",\n" +
                "          \"events_url\": \"https://api.github.com/users/DaveCTurner/events{/privacy}\",\n" +
                "          \"received_events_url\": \"https://api.github.com/users/DaveCTurner/received_events\",\n" +
                "          \"type\": \"User\",\n" +
                "          \"site_admin\": false\n" +
                "        },\n" +
                "        \"private\": false,\n" +
                "        \"html_url\": \"https://github.com/DaveCTurner/elasticsearch\",\n" +
                "        \"description\": \"Open Source, Distributed, RESTful Search Engine\",\n" +
                "        \"fork\": true,\n" +
                "        \"url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch\",\n" +
                "        \"forks_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/forks\",\n" +
                "        \"keys_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/keys{/key_id}\",\n" +
                "        \"collaborators_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/collaborators{/collaborator}\",\n" +
                "        \"teams_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/teams\",\n" +
                "        \"hooks_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/hooks\",\n" +
                "        \"issue_events_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/issues/events{/number}\",\n" +
                "        \"events_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/events\",\n" +
                "        \"assignees_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/assignees{/user}\",\n" +
                "        \"branches_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/branches{/branch}\",\n" +
                "        \"tags_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/tags\",\n" +
                "        \"blobs_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/git/blobs{/sha}\",\n" +
                "        \"git_tags_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/git/tags{/sha}\",\n" +
                "        \"git_refs_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/git/refs{/sha}\",\n" +
                "        \"trees_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/git/trees{/sha}\",\n" +
                "        \"statuses_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/statuses/{sha}\",\n" +
                "        \"languages_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/languages\",\n" +
                "        \"stargazers_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/stargazers\",\n" +
                "        \"contributors_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/contributors\",\n" +
                "        \"subscribers_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/subscribers\",\n" +
                "        \"subscription_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/subscription\",\n" +
                "        \"commits_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/commits{/sha}\",\n" +
                "        \"git_commits_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/git/commits{/sha}\",\n" +
                "        \"comments_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/comments{/number}\",\n" +
                "        \"issue_comment_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/issues/comments{/number}\",\n" +
                "        \"contents_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/contents/{+path}\",\n" +
                "        \"compare_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/compare/{base}...{head}\",\n" +
                "        \"merges_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/merges\",\n" +
                "        \"archive_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/{archive_format}{/ref}\",\n" +
                "        \"downloads_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/downloads\",\n" +
                "        \"issues_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/issues{/number}\",\n" +
                "        \"pulls_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/pulls{/number}\",\n" +
                "        \"milestones_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/milestones{/number}\",\n" +
                "        \"notifications_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/notifications{?since,all,participating}\",\n" +
                "        \"labels_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/labels{/name}\",\n" +
                "        \"releases_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/releases{/id}\",\n" +
                "        \"deployments_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/deployments\",\n" +
                "        \"created_at\": \"2017-09-21T04:38:01Z\",\n" +
                "        \"updated_at\": \"2017-09-21T04:38:38Z\",\n" +
                "        \"pushed_at\": \"2017-12-22T19:18:32Z\",\n" +
                "        \"git_url\": \"git://github.com/DaveCTurner/elasticsearch.git\",\n" +
                "        \"ssh_url\": \"git@github.com:DaveCTurner/elasticsearch.git\",\n" +
                "        \"clone_url\": \"https://github.com/DaveCTurner/elasticsearch.git\",\n" +
                "        \"svn_url\": \"https://github.com/DaveCTurner/elasticsearch\",\n" +
                "        \"homepage\": \"https://www.elastic.co/products/elasticsearch\",\n" +
                "        \"size\": 378924,\n" +
                "        \"stargazers_count\": 0,\n" +
                "        \"watchers_count\": 0,\n" +
                "        \"language\": \"Java\",\n" +
                "        \"has_issues\": false,\n" +
                "        \"has_projects\": true,\n" +
                "        \"has_downloads\": true,\n" +
                "        \"has_wiki\": false,\n" +
                "        \"has_pages\": false,\n" +
                "        \"forks_count\": 0,\n" +
                "        \"mirror_url\": null,\n" +
                "        \"archived\": false,\n" +
                "        \"open_issues_count\": 0,\n" +
                "        \"license\": {\n" +
                "          \"key\": \"apache-2.0\",\n" +
                "          \"name\": \"Apache License 2.0\",\n" +
                "          \"spdx_id\": \"Apache-2.0\",\n" +
                "          \"url\": \"https://api.github.com/licenses/apache-2.0\"\n" +
                "        },\n" +
                "        \"forks\": 0,\n" +
                "        \"open_issues\": 0,\n" +
                "        \"watchers\": 0,\n" +
                "        \"default_branch\": \"master\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"base\": {\n" +
                "      \"label\": \"elastic:master\",\n" +
                "      \"ref\": \"master\",\n" +
                "      \"sha\": \"0375d887f26223963a0cd83b43ccb7022491c32e\",\n" +
                "      \"user\": {\n" +
                "        \"login\": \"elastic\",\n" +
                "        \"id\": 6764390,\n" +
                "        \"avatar_url\": \"https://avatars0.githubusercontent.com/u/6764390?v=4\",\n" +
                "        \"gravatar_id\": \"\",\n" +
                "        \"url\": \"https://api.github.com/users/elastic\",\n" +
                "        \"html_url\": \"https://github.com/elastic\",\n" +
                "        \"followers_url\": \"https://api.github.com/users/elastic/followers\",\n" +
                "        \"following_url\": \"https://api.github.com/users/elastic/following{/other_user}\",\n" +
                "        \"gists_url\": \"https://api.github.com/users/elastic/gists{/gist_id}\",\n" +
                "        \"starred_url\": \"https://api.github.com/users/elastic/starred{/owner}{/repo}\",\n" +
                "        \"subscriptions_url\": \"https://api.github.com/users/elastic/subscriptions\",\n" +
                "        \"organizations_url\": \"https://api.github.com/users/elastic/orgs\",\n" +
                "        \"repos_url\": \"https://api.github.com/users/elastic/repos\",\n" +
                "        \"events_url\": \"https://api.github.com/users/elastic/events{/privacy}\",\n" +
                "        \"received_events_url\": \"https://api.github.com/users/elastic/received_events\",\n" +
                "        \"type\": \"Organization\",\n" +
                "        \"site_admin\": false\n" +
                "      },\n" +
                "      \"repo\": {\n" +
                "        \"id\": 507775,\n" +
                "        \"name\": \"elasticsearch\",\n" +
                "        \"full_name\": \"elastic/elasticsearch\",\n" +
                "        \"owner\": {\n" +
                "          \"login\": \"elastic\",\n" +
                "          \"id\": 6764390,\n" +
                "          \"avatar_url\": \"https://avatars0.githubusercontent.com/u/6764390?v=4\",\n" +
                "          \"gravatar_id\": \"\",\n" +
                "          \"url\": \"https://api.github.com/users/elastic\",\n" +
                "          \"html_url\": \"https://github.com/elastic\",\n" +
                "          \"followers_url\": \"https://api.github.com/users/elastic/followers\",\n" +
                "          \"following_url\": \"https://api.github.com/users/elastic/following{/other_user}\",\n" +
                "          \"gists_url\": \"https://api.github.com/users/elastic/gists{/gist_id}\",\n" +
                "          \"starred_url\": \"https://api.github.com/users/elastic/starred{/owner}{/repo}\",\n" +
                "          \"subscriptions_url\": \"https://api.github.com/users/elastic/subscriptions\",\n" +
                "          \"organizations_url\": \"https://api.github.com/users/elastic/orgs\",\n" +
                "          \"repos_url\": \"https://api.github.com/users/elastic/repos\",\n" +
                "          \"events_url\": \"https://api.github.com/users/elastic/events{/privacy}\",\n" +
                "          \"received_events_url\": \"https://api.github.com/users/elastic/received_events\",\n" +
                "          \"type\": \"Organization\",\n" +
                "          \"site_admin\": false\n" +
                "        },\n" +
                "        \"private\": false,\n" +
                "        \"html_url\": \"https://github.com/elastic/elasticsearch\",\n" +
                "        \"description\": \"Open Source, Distributed, RESTful Search Engine\",\n" +
                "        \"fork\": false,\n" +
                "        \"url\": \"https://api.github.com/repos/elastic/elasticsearch\",\n" +
                "        \"forks_url\": \"https://api.github.com/repos/elastic/elasticsearch/forks\",\n" +
                "        \"keys_url\": \"https://api.github.com/repos/elastic/elasticsearch/keys{/key_id}\",\n" +
                "        \"collaborators_url\": \"https://api.github.com/repos/elastic/elasticsearch/collaborators{/collaborator}\",\n" +
                "        \"teams_url\": \"https://api.github.com/repos/elastic/elasticsearch/teams\",\n" +
                "        \"hooks_url\": \"https://api.github.com/repos/elastic/elasticsearch/hooks\",\n" +
                "        \"issue_events_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues/events{/number}\",\n" +
                "        \"events_url\": \"https://api.github.com/repos/elastic/elasticsearch/events\",\n" +
                "        \"assignees_url\": \"https://api.github.com/repos/elastic/elasticsearch/assignees{/user}\",\n" +
                "        \"branches_url\": \"https://api.github.com/repos/elastic/elasticsearch/branches{/branch}\",\n" +
                "        \"tags_url\": \"https://api.github.com/repos/elastic/elasticsearch/tags\",\n" +
                "        \"blobs_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/blobs{/sha}\",\n" +
                "        \"git_tags_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/tags{/sha}\",\n" +
                "        \"git_refs_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/refs{/sha}\",\n" +
                "        \"trees_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/trees{/sha}\",\n" +
                "        \"statuses_url\": \"https://api.github.com/repos/elastic/elasticsearch/statuses/{sha}\",\n" +
                "        \"languages_url\": \"https://api.github.com/repos/elastic/elasticsearch/languages\",\n" +
                "        \"stargazers_url\": \"https://api.github.com/repos/elastic/elasticsearch/stargazers\",\n" +
                "        \"contributors_url\": \"https://api.github.com/repos/elastic/elasticsearch/contributors\",\n" +
                "        \"subscribers_url\": \"https://api.github.com/repos/elastic/elasticsearch/subscribers\",\n" +
                "        \"subscription_url\": \"https://api.github.com/repos/elastic/elasticsearch/subscription\",\n" +
                "        \"commits_url\": \"https://api.github.com/repos/elastic/elasticsearch/commits{/sha}\",\n" +
                "        \"git_commits_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/commits{/sha}\",\n" +
                "        \"comments_url\": \"https://api.github.com/repos/elastic/elasticsearch/comments{/number}\",\n" +
                "        \"issue_comment_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues/comments{/number}\",\n" +
                "        \"contents_url\": \"https://api.github.com/repos/elastic/elasticsearch/contents/{+path}\",\n" +
                "        \"compare_url\": \"https://api.github.com/repos/elastic/elasticsearch/compare/{base}...{head}\",\n" +
                "        \"merges_url\": \"https://api.github.com/repos/elastic/elasticsearch/merges\",\n" +
                "        \"archive_url\": \"https://api.github.com/repos/elastic/elasticsearch/{archive_format}{/ref}\",\n" +
                "        \"downloads_url\": \"https://api.github.com/repos/elastic/elasticsearch/downloads\",\n" +
                "        \"issues_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues{/number}\",\n" +
                "        \"pulls_url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls{/number}\",\n" +
                "        \"milestones_url\": \"https://api.github.com/repos/elastic/elasticsearch/milestones{/number}\",\n" +
                "        \"notifications_url\": \"https://api.github.com/repos/elastic/elasticsearch/notifications{?since,all,participating}\",\n" +
                "        \"labels_url\": \"https://api.github.com/repos/elastic/elasticsearch/labels{/name}\",\n" +
                "        \"releases_url\": \"https://api.github.com/repos/elastic/elasticsearch/releases{/id}\",\n" +
                "        \"deployments_url\": \"https://api.github.com/repos/elastic/elasticsearch/deployments\",\n" +
                "        \"created_at\": \"2010-02-08T13:20:56Z\",\n" +
                "        \"updated_at\": \"2017-12-22T18:17:34Z\",\n" +
                "        \"pushed_at\": \"2017-12-22T21:42:20Z\",\n" +
                "        \"git_url\": \"git://github.com/elastic/elasticsearch.git\",\n" +
                "        \"ssh_url\": \"git@github.com:elastic/elasticsearch.git\",\n" +
                "        \"clone_url\": \"https://github.com/elastic/elasticsearch.git\",\n" +
                "        \"svn_url\": \"https://github.com/elastic/elasticsearch\",\n" +
                "        \"homepage\": \"https://www.elastic.co/products/elasticsearch\",\n" +
                "        \"size\": 380040,\n" +
                "        \"stargazers_count\": 27534,\n" +
                "        \"watchers_count\": 27534,\n" +
                "        \"language\": \"Java\",\n" +
                "        \"has_issues\": true,\n" +
                "        \"has_projects\": true,\n" +
                "        \"has_downloads\": true,\n" +
                "        \"has_wiki\": false,\n" +
                "        \"has_pages\": false,\n" +
                "        \"forks_count\": 9630,\n" +
                "        \"mirror_url\": null,\n" +
                "        \"archived\": false,\n" +
                "        \"open_issues_count\": 1347,\n" +
                "        \"license\": {\n" +
                "          \"key\": \"apache-2.0\",\n" +
                "          \"name\": \"Apache License 2.0\",\n" +
                "          \"spdx_id\": \"Apache-2.0\",\n" +
                "          \"url\": \"https://api.github.com/licenses/apache-2.0\"\n" +
                "        },\n" +
                "        \"forks\": 9630,\n" +
                "        \"open_issues\": 1347,\n" +
                "        \"watchers\": 27534,\n" +
                "        \"default_branch\": \"master\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"_links\": {\n" +
                "      \"self\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/27967\"\n" +
                "      },\n" +
                "      \"html\": {\n" +
                "        \"href\": \"https://github.com/elastic/elasticsearch/pull/27967\"\n" +
                "      },\n" +
                "      \"issue\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/issues/27967\"\n" +
                "      },\n" +
                "      \"comments\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/issues/27967/comments\"\n" +
                "      },\n" +
                "      \"review_comments\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/27967/comments\"\n" +
                "      },\n" +
                "      \"review_comment\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/comments{/number}\"\n" +
                "      },\n" +
                "      \"commits\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/27967/commits\"\n" +
                "      },\n" +
                "      \"statuses\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/statuses/bcfb796b6884651f5761b2cfb257fa70175b8d47\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"author_association\": \"CONTRIBUTOR\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/27964\",\n" +
                "    \"id\": 159861613,\n" +
                "    \"html_url\": \"https://github.com/elastic/elasticsearch/pull/27964\",\n" +
                "    \"diff_url\": \"https://github.com/elastic/elasticsearch/pull/27964.diff\",\n" +
                "    \"patch_url\": \"https://github.com/elastic/elasticsearch/pull/27964.patch\",\n" +
                "    \"issue_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues/27964\",\n" +
                "    \"number\": 27964,\n" +
                "    \"state\": \"open\",\n" +
                "    \"locked\": false,\n" +
                "    \"title\": \"Clarify which query types expect false positives and negatives\",\n" +
                "    \"user\": {\n" +
                "      \"login\": \"DaveCTurner\",\n" +
                "      \"id\": 5058284,\n" +
                "      \"avatar_url\": \"https://avatars3.githubusercontent.com/u/5058284?v=4\",\n" +
                "      \"gravatar_id\": \"\",\n" +
                "      \"url\": \"https://api.github.com/users/DaveCTurner\",\n" +
                "      \"html_url\": \"https://github.com/DaveCTurner\",\n" +
                "      \"followers_url\": \"https://api.github.com/users/DaveCTurner/followers\",\n" +
                "      \"following_url\": \"https://api.github.com/users/DaveCTurner/following{/other_user}\",\n" +
                "      \"gists_url\": \"https://api.github.com/users/DaveCTurner/gists{/gist_id}\",\n" +
                "      \"starred_url\": \"https://api.github.com/users/DaveCTurner/starred{/owner}{/repo}\",\n" +
                "      \"subscriptions_url\": \"https://api.github.com/users/DaveCTurner/subscriptions\",\n" +
                "      \"organizations_url\": \"https://api.github.com/users/DaveCTurner/orgs\",\n" +
                "      \"repos_url\": \"https://api.github.com/users/DaveCTurner/repos\",\n" +
                "      \"events_url\": \"https://api.github.com/users/DaveCTurner/events{/privacy}\",\n" +
                "      \"received_events_url\": \"https://api.github.com/users/DaveCTurner/received_events\",\n" +
                "      \"type\": \"User\",\n" +
                "      \"site_admin\": false\n" +
                "    },\n" +
                "    \"body\": \"I think this'd help with a couple of support cases I've seen recently. Is this clarification correct?\",\n" +
                "    \"created_at\": \"2017-12-22T12:46:25Z\",\n" +
                "    \"updated_at\": \"2017-12-22T12:46:26Z\",\n" +
                "    \"closed_at\": null,\n" +
                "    \"merged_at\": null,\n" +
                "    \"merge_commit_sha\": \"21ef055a48d3191f21005df4a94392efddd94e20\",\n" +
                "    \"assignee\": null,\n" +
                "    \"assignees\": [\n" +
                "\n" +
                "    ],\n" +
                "    \"requested_reviewers\": [\n" +
                "      {\n" +
                "        \"login\": \"nknize\",\n" +
                "        \"id\": 830187,\n" +
                "        \"avatar_url\": \"https://avatars3.githubusercontent.com/u/830187?v=4\",\n" +
                "        \"gravatar_id\": \"\",\n" +
                "        \"url\": \"https://api.github.com/users/nknize\",\n" +
                "        \"html_url\": \"https://github.com/nknize\",\n" +
                "        \"followers_url\": \"https://api.github.com/users/nknize/followers\",\n" +
                "        \"following_url\": \"https://api.github.com/users/nknize/following{/other_user}\",\n" +
                "        \"gists_url\": \"https://api.github.com/users/nknize/gists{/gist_id}\",\n" +
                "        \"starred_url\": \"https://api.github.com/users/nknize/starred{/owner}{/repo}\",\n" +
                "        \"subscriptions_url\": \"https://api.github.com/users/nknize/subscriptions\",\n" +
                "        \"organizations_url\": \"https://api.github.com/users/nknize/orgs\",\n" +
                "        \"repos_url\": \"https://api.github.com/users/nknize/repos\",\n" +
                "        \"events_url\": \"https://api.github.com/users/nknize/events{/privacy}\",\n" +
                "        \"received_events_url\": \"https://api.github.com/users/nknize/received_events\",\n" +
                "        \"type\": \"User\",\n" +
                "        \"site_admin\": false\n" +
                "      }\n" +
                "    ],\n" +
                "    \"milestone\": null,\n" +
                "    \"commits_url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/27964/commits\",\n" +
                "    \"review_comments_url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/27964/comments\",\n" +
                "    \"review_comment_url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/comments{/number}\",\n" +
                "    \"comments_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues/27964/comments\",\n" +
                "    \"statuses_url\": \"https://api.github.com/repos/elastic/elasticsearch/statuses/4ab30217d1dd36a4d7e8fdffd6ae6ad15999f3df\",\n" +
                "    \"head\": {\n" +
                "      \"label\": \"DaveCTurner:2017-12-22-false-positives-negatives-clarification\",\n" +
                "      \"ref\": \"2017-12-22-false-positives-negatives-clarification\",\n" +
                "      \"sha\": \"4ab30217d1dd36a4d7e8fdffd6ae6ad15999f3df\",\n" +
                "      \"user\": {\n" +
                "        \"login\": \"DaveCTurner\",\n" +
                "        \"id\": 5058284,\n" +
                "        \"avatar_url\": \"https://avatars3.githubusercontent.com/u/5058284?v=4\",\n" +
                "        \"gravatar_id\": \"\",\n" +
                "        \"url\": \"https://api.github.com/users/DaveCTurner\",\n" +
                "        \"html_url\": \"https://github.com/DaveCTurner\",\n" +
                "        \"followers_url\": \"https://api.github.com/users/DaveCTurner/followers\",\n" +
                "        \"following_url\": \"https://api.github.com/users/DaveCTurner/following{/other_user}\",\n" +
                "        \"gists_url\": \"https://api.github.com/users/DaveCTurner/gists{/gist_id}\",\n" +
                "        \"starred_url\": \"https://api.github.com/users/DaveCTurner/starred{/owner}{/repo}\",\n" +
                "        \"subscriptions_url\": \"https://api.github.com/users/DaveCTurner/subscriptions\",\n" +
                "        \"organizations_url\": \"https://api.github.com/users/DaveCTurner/orgs\",\n" +
                "        \"repos_url\": \"https://api.github.com/users/DaveCTurner/repos\",\n" +
                "        \"events_url\": \"https://api.github.com/users/DaveCTurner/events{/privacy}\",\n" +
                "        \"received_events_url\": \"https://api.github.com/users/DaveCTurner/received_events\",\n" +
                "        \"type\": \"User\",\n" +
                "        \"site_admin\": false\n" +
                "      },\n" +
                "      \"repo\": {\n" +
                "        \"id\": 104302209,\n" +
                "        \"name\": \"elasticsearch\",\n" +
                "        \"full_name\": \"DaveCTurner/elasticsearch\",\n" +
                "        \"owner\": {\n" +
                "          \"login\": \"DaveCTurner\",\n" +
                "          \"id\": 5058284,\n" +
                "          \"avatar_url\": \"https://avatars3.githubusercontent.com/u/5058284?v=4\",\n" +
                "          \"gravatar_id\": \"\",\n" +
                "          \"url\": \"https://api.github.com/users/DaveCTurner\",\n" +
                "          \"html_url\": \"https://github.com/DaveCTurner\",\n" +
                "          \"followers_url\": \"https://api.github.com/users/DaveCTurner/followers\",\n" +
                "          \"following_url\": \"https://api.github.com/users/DaveCTurner/following{/other_user}\",\n" +
                "          \"gists_url\": \"https://api.github.com/users/DaveCTurner/gists{/gist_id}\",\n" +
                "          \"starred_url\": \"https://api.github.com/users/DaveCTurner/starred{/owner}{/repo}\",\n" +
                "          \"subscriptions_url\": \"https://api.github.com/users/DaveCTurner/subscriptions\",\n" +
                "          \"organizations_url\": \"https://api.github.com/users/DaveCTurner/orgs\",\n" +
                "          \"repos_url\": \"https://api.github.com/users/DaveCTurner/repos\",\n" +
                "          \"events_url\": \"https://api.github.com/users/DaveCTurner/events{/privacy}\",\n" +
                "          \"received_events_url\": \"https://api.github.com/users/DaveCTurner/received_events\",\n" +
                "          \"type\": \"User\",\n" +
                "          \"site_admin\": false\n" +
                "        },\n" +
                "        \"private\": false,\n" +
                "        \"html_url\": \"https://github.com/DaveCTurner/elasticsearch\",\n" +
                "        \"description\": \"Open Source, Distributed, RESTful Search Engine\",\n" +
                "        \"fork\": true,\n" +
                "        \"url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch\",\n" +
                "        \"forks_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/forks\",\n" +
                "        \"keys_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/keys{/key_id}\",\n" +
                "        \"collaborators_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/collaborators{/collaborator}\",\n" +
                "        \"teams_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/teams\",\n" +
                "        \"hooks_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/hooks\",\n" +
                "        \"issue_events_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/issues/events{/number}\",\n" +
                "        \"events_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/events\",\n" +
                "        \"assignees_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/assignees{/user}\",\n" +
                "        \"branches_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/branches{/branch}\",\n" +
                "        \"tags_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/tags\",\n" +
                "        \"blobs_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/git/blobs{/sha}\",\n" +
                "        \"git_tags_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/git/tags{/sha}\",\n" +
                "        \"git_refs_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/git/refs{/sha}\",\n" +
                "        \"trees_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/git/trees{/sha}\",\n" +
                "        \"statuses_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/statuses/{sha}\",\n" +
                "        \"languages_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/languages\",\n" +
                "        \"stargazers_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/stargazers\",\n" +
                "        \"contributors_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/contributors\",\n" +
                "        \"subscribers_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/subscribers\",\n" +
                "        \"subscription_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/subscription\",\n" +
                "        \"commits_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/commits{/sha}\",\n" +
                "        \"git_commits_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/git/commits{/sha}\",\n" +
                "        \"comments_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/comments{/number}\",\n" +
                "        \"issue_comment_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/issues/comments{/number}\",\n" +
                "        \"contents_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/contents/{+path}\",\n" +
                "        \"compare_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/compare/{base}...{head}\",\n" +
                "        \"merges_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/merges\",\n" +
                "        \"archive_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/{archive_format}{/ref}\",\n" +
                "        \"downloads_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/downloads\",\n" +
                "        \"issues_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/issues{/number}\",\n" +
                "        \"pulls_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/pulls{/number}\",\n" +
                "        \"milestones_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/milestones{/number}\",\n" +
                "        \"notifications_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/notifications{?since,all,participating}\",\n" +
                "        \"labels_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/labels{/name}\",\n" +
                "        \"releases_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/releases{/id}\",\n" +
                "        \"deployments_url\": \"https://api.github.com/repos/DaveCTurner/elasticsearch/deployments\",\n" +
                "        \"created_at\": \"2017-09-21T04:38:01Z\",\n" +
                "        \"updated_at\": \"2017-09-21T04:38:38Z\",\n" +
                "        \"pushed_at\": \"2017-12-22T19:18:32Z\",\n" +
                "        \"git_url\": \"git://github.com/DaveCTurner/elasticsearch.git\",\n" +
                "        \"ssh_url\": \"git@github.com:DaveCTurner/elasticsearch.git\",\n" +
                "        \"clone_url\": \"https://github.com/DaveCTurner/elasticsearch.git\",\n" +
                "        \"svn_url\": \"https://github.com/DaveCTurner/elasticsearch\",\n" +
                "        \"homepage\": \"https://www.elastic.co/products/elasticsearch\",\n" +
                "        \"size\": 378924,\n" +
                "        \"stargazers_count\": 0,\n" +
                "        \"watchers_count\": 0,\n" +
                "        \"language\": \"Java\",\n" +
                "        \"has_issues\": false,\n" +
                "        \"has_projects\": true,\n" +
                "        \"has_downloads\": true,\n" +
                "        \"has_wiki\": false,\n" +
                "        \"has_pages\": false,\n" +
                "        \"forks_count\": 0,\n" +
                "        \"mirror_url\": null,\n" +
                "        \"archived\": false,\n" +
                "        \"open_issues_count\": 0,\n" +
                "        \"license\": {\n" +
                "          \"key\": \"apache-2.0\",\n" +
                "          \"name\": \"Apache License 2.0\",\n" +
                "          \"spdx_id\": \"Apache-2.0\",\n" +
                "          \"url\": \"https://api.github.com/licenses/apache-2.0\"\n" +
                "        },\n" +
                "        \"forks\": 0,\n" +
                "        \"open_issues\": 0,\n" +
                "        \"watchers\": 0,\n" +
                "        \"default_branch\": \"master\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"base\": {\n" +
                "      \"label\": \"elastic:master\",\n" +
                "      \"ref\": \"master\",\n" +
                "      \"sha\": \"0423155fc6941f964f4694b1188c1238465db277\",\n" +
                "      \"user\": {\n" +
                "        \"login\": \"elastic\",\n" +
                "        \"id\": 6764390,\n" +
                "        \"avatar_url\": \"https://avatars0.githubusercontent.com/u/6764390?v=4\",\n" +
                "        \"gravatar_id\": \"\",\n" +
                "        \"url\": \"https://api.github.com/users/elastic\",\n" +
                "        \"html_url\": \"https://github.com/elastic\",\n" +
                "        \"followers_url\": \"https://api.github.com/users/elastic/followers\",\n" +
                "        \"following_url\": \"https://api.github.com/users/elastic/following{/other_user}\",\n" +
                "        \"gists_url\": \"https://api.github.com/users/elastic/gists{/gist_id}\",\n" +
                "        \"starred_url\": \"https://api.github.com/users/elastic/starred{/owner}{/repo}\",\n" +
                "        \"subscriptions_url\": \"https://api.github.com/users/elastic/subscriptions\",\n" +
                "        \"organizations_url\": \"https://api.github.com/users/elastic/orgs\",\n" +
                "        \"repos_url\": \"https://api.github.com/users/elastic/repos\",\n" +
                "        \"events_url\": \"https://api.github.com/users/elastic/events{/privacy}\",\n" +
                "        \"received_events_url\": \"https://api.github.com/users/elastic/received_events\",\n" +
                "        \"type\": \"Organization\",\n" +
                "        \"site_admin\": false\n" +
                "      },\n" +
                "      \"repo\": {\n" +
                "        \"id\": 507775,\n" +
                "        \"name\": \"elasticsearch\",\n" +
                "        \"full_name\": \"elastic/elasticsearch\",\n" +
                "        \"owner\": {\n" +
                "          \"login\": \"elastic\",\n" +
                "          \"id\": 6764390,\n" +
                "          \"avatar_url\": \"https://avatars0.githubusercontent.com/u/6764390?v=4\",\n" +
                "          \"gravatar_id\": \"\",\n" +
                "          \"url\": \"https://api.github.com/users/elastic\",\n" +
                "          \"html_url\": \"https://github.com/elastic\",\n" +
                "          \"followers_url\": \"https://api.github.com/users/elastic/followers\",\n" +
                "          \"following_url\": \"https://api.github.com/users/elastic/following{/other_user}\",\n" +
                "          \"gists_url\": \"https://api.github.com/users/elastic/gists{/gist_id}\",\n" +
                "          \"starred_url\": \"https://api.github.com/users/elastic/starred{/owner}{/repo}\",\n" +
                "          \"subscriptions_url\": \"https://api.github.com/users/elastic/subscriptions\",\n" +
                "          \"organizations_url\": \"https://api.github.com/users/elastic/orgs\",\n" +
                "          \"repos_url\": \"https://api.github.com/users/elastic/repos\",\n" +
                "          \"events_url\": \"https://api.github.com/users/elastic/events{/privacy}\",\n" +
                "          \"received_events_url\": \"https://api.github.com/users/elastic/received_events\",\n" +
                "          \"type\": \"Organization\",\n" +
                "          \"site_admin\": false\n" +
                "        },\n" +
                "        \"private\": false,\n" +
                "        \"html_url\": \"https://github.com/elastic/elasticsearch\",\n" +
                "        \"description\": \"Open Source, Distributed, RESTful Search Engine\",\n" +
                "        \"fork\": false,\n" +
                "        \"url\": \"https://api.github.com/repos/elastic/elasticsearch\",\n" +
                "        \"forks_url\": \"https://api.github.com/repos/elastic/elasticsearch/forks\",\n" +
                "        \"keys_url\": \"https://api.github.com/repos/elastic/elasticsearch/keys{/key_id}\",\n" +
                "        \"collaborators_url\": \"https://api.github.com/repos/elastic/elasticsearch/collaborators{/collaborator}\",\n" +
                "        \"teams_url\": \"https://api.github.com/repos/elastic/elasticsearch/teams\",\n" +
                "        \"hooks_url\": \"https://api.github.com/repos/elastic/elasticsearch/hooks\",\n" +
                "        \"issue_events_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues/events{/number}\",\n" +
                "        \"events_url\": \"https://api.github.com/repos/elastic/elasticsearch/events\",\n" +
                "        \"assignees_url\": \"https://api.github.com/repos/elastic/elasticsearch/assignees{/user}\",\n" +
                "        \"branches_url\": \"https://api.github.com/repos/elastic/elasticsearch/branches{/branch}\",\n" +
                "        \"tags_url\": \"https://api.github.com/repos/elastic/elasticsearch/tags\",\n" +
                "        \"blobs_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/blobs{/sha}\",\n" +
                "        \"git_tags_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/tags{/sha}\",\n" +
                "        \"git_refs_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/refs{/sha}\",\n" +
                "        \"trees_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/trees{/sha}\",\n" +
                "        \"statuses_url\": \"https://api.github.com/repos/elastic/elasticsearch/statuses/{sha}\",\n" +
                "        \"languages_url\": \"https://api.github.com/repos/elastic/elasticsearch/languages\",\n" +
                "        \"stargazers_url\": \"https://api.github.com/repos/elastic/elasticsearch/stargazers\",\n" +
                "        \"contributors_url\": \"https://api.github.com/repos/elastic/elasticsearch/contributors\",\n" +
                "        \"subscribers_url\": \"https://api.github.com/repos/elastic/elasticsearch/subscribers\",\n" +
                "        \"subscription_url\": \"https://api.github.com/repos/elastic/elasticsearch/subscription\",\n" +
                "        \"commits_url\": \"https://api.github.com/repos/elastic/elasticsearch/commits{/sha}\",\n" +
                "        \"git_commits_url\": \"https://api.github.com/repos/elastic/elasticsearch/git/commits{/sha}\",\n" +
                "        \"comments_url\": \"https://api.github.com/repos/elastic/elasticsearch/comments{/number}\",\n" +
                "        \"issue_comment_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues/comments{/number}\",\n" +
                "        \"contents_url\": \"https://api.github.com/repos/elastic/elasticsearch/contents/{+path}\",\n" +
                "        \"compare_url\": \"https://api.github.com/repos/elastic/elasticsearch/compare/{base}...{head}\",\n" +
                "        \"merges_url\": \"https://api.github.com/repos/elastic/elasticsearch/merges\",\n" +
                "        \"archive_url\": \"https://api.github.com/repos/elastic/elasticsearch/{archive_format}{/ref}\",\n" +
                "        \"downloads_url\": \"https://api.github.com/repos/elastic/elasticsearch/downloads\",\n" +
                "        \"issues_url\": \"https://api.github.com/repos/elastic/elasticsearch/issues{/number}\",\n" +
                "        \"pulls_url\": \"https://api.github.com/repos/elastic/elasticsearch/pulls{/number}\",\n" +
                "        \"milestones_url\": \"https://api.github.com/repos/elastic/elasticsearch/milestones{/number}\",\n" +
                "        \"notifications_url\": \"https://api.github.com/repos/elastic/elasticsearch/notifications{?since,all,participating}\",\n" +
                "        \"labels_url\": \"https://api.github.com/repos/elastic/elasticsearch/labels{/name}\",\n" +
                "        \"releases_url\": \"https://api.github.com/repos/elastic/elasticsearch/releases{/id}\",\n" +
                "        \"deployments_url\": \"https://api.github.com/repos/elastic/elasticsearch/deployments\",\n" +
                "        \"created_at\": \"2010-02-08T13:20:56Z\",\n" +
                "        \"updated_at\": \"2017-12-22T18:17:34Z\",\n" +
                "        \"pushed_at\": \"2017-12-22T21:42:20Z\",\n" +
                "        \"git_url\": \"git://github.com/elastic/elasticsearch.git\",\n" +
                "        \"ssh_url\": \"git@github.com:elastic/elasticsearch.git\",\n" +
                "        \"clone_url\": \"https://github.com/elastic/elasticsearch.git\",\n" +
                "        \"svn_url\": \"https://github.com/elastic/elasticsearch\",\n" +
                "        \"homepage\": \"https://www.elastic.co/products/elasticsearch\",\n" +
                "        \"size\": 380040,\n" +
                "        \"stargazers_count\": 27534,\n" +
                "        \"watchers_count\": 27534,\n" +
                "        \"language\": \"Java\",\n" +
                "        \"has_issues\": true,\n" +
                "        \"has_projects\": true,\n" +
                "        \"has_downloads\": true,\n" +
                "        \"has_wiki\": false,\n" +
                "        \"has_pages\": false,\n" +
                "        \"forks_count\": 9630,\n" +
                "        \"mirror_url\": null,\n" +
                "        \"archived\": false,\n" +
                "        \"open_issues_count\": 1347,\n" +
                "        \"license\": {\n" +
                "          \"key\": \"apache-2.0\",\n" +
                "          \"name\": \"Apache License 2.0\",\n" +
                "          \"spdx_id\": \"Apache-2.0\",\n" +
                "          \"url\": \"https://api.github.com/licenses/apache-2.0\"\n" +
                "        },\n" +
                "        \"forks\": 9630,\n" +
                "        \"open_issues\": 1347,\n" +
                "        \"watchers\": 27534,\n" +
                "        \"default_branch\": \"master\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"_links\": {\n" +
                "      \"self\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/27964\"\n" +
                "      },\n" +
                "      \"html\": {\n" +
                "        \"href\": \"https://github.com/elastic/elasticsearch/pull/27964\"\n" +
                "      },\n" +
                "      \"issue\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/issues/27964\"\n" +
                "      },\n" +
                "      \"comments\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/issues/27964/comments\"\n" +
                "      },\n" +
                "      \"review_comments\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/27964/comments\"\n" +
                "      },\n" +
                "      \"review_comment\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/comments{/number}\"\n" +
                "      },\n" +
                "      \"commits\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/pulls/27964/commits\"\n" +
                "      },\n" +
                "      \"statuses\": {\n" +
                "        \"href\": \"https://api.github.com/repos/elastic/elasticsearch/statuses/4ab30217d1dd36a4d7e8fdffd6ae6ad15999f3df\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"author_association\": \"CONTRIBUTOR\"\n" +
                "  }\n" +
                "]";
    }
}
