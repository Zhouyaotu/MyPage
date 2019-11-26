<template>
  <div class="app">
    <!-- 将获取到的数据进行计算 -->
    <div v-for="stu in stulist" v-bind:key="stu.base.uid" style="width: 100%">
      <el-container type="flex">
        <el-aside width="250px">
        </el-aside>
        <el-main>
          <el-row type="flex" justify="start">{{stu.base.username}}</el-row>
          <el-row type="flex" justify="start">{{stu.detail.id}}</el-row>
          <el-row type="flex" justify="start">我的话题</el-row>
        </el-main>
      </el-container>
    </div>
    <div class="tabListPage">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-sizes="pageSizes"
        :page-size="PageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="totalCount"
      ></el-pagination>
    </div>
  </div>
</template>

<script>
import Headimg from "@/components/common/Headimg";
import Stutags from "@/components/common/Stutags";
export default {
  name: "Recommendtopic",
  data() {
    return {
      // localhost
      host: this.$axios.defaults.hostport,
      // 总数据
      stulist: [],
      // 默认显示第几页
      currentPage: 1,
      // 个数选择器（可修改）
      pageSizes: [1, 2, 5, 10],
      // 默认每页显示的条数（可修改）
      PageSize: 5,
      // 总条数，根据接口获取数据长度(注意：这里不能为空)
      totalCount: 20
    };
  },
  components: {
    Headimg,
    Stutags
  },
  methods: {
    getData() {
      // 这里使用axios，使用时请提前引入
      var _this = this;
      this.$axios
        .post(
          "/user/get-all-user-info",
          { pageNum: _this.currentPage, pageSize: _this.PageSize },
          { emulateJSON: true }
        )
        .then(resp => {
          if (resp && resp.status === 200) {
            _this.stulist = resp.data.attribute.users;
            _this.resCode = resp.data.code;
            _this.totalCount = resp.data.attribute.totalCount;
          }
        });
    },
    // 分页
    // 每页显示的条数
    handleSizeChange(val) {
      // 改变每页显示的条数
      this.PageSize = val;
      // 注意：在改变每页显示的条数时，要将页码显示到第一页
      this.currentPage = 1;
      this.getData()
    },
    // 显示第几页
    handleCurrentChange(val) {
      // 改变默认的页数
      this.currentPage = val;
      this.getData()
    }
  },
  created: function() {
    this.getData();
  }
};
</script>

