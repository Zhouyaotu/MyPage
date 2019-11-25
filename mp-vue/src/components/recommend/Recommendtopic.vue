<template>
  <div class="app">    
    <!-- 将获取到的数据进行计算 -->   
    <el-table :data="tableData.slice((currentPage-1)*PageSize,currentPage*PageSize)" style="width: 100%">
      <el-table-column prop="date" label="日期" width="180"></el-table-column>
      <el-table-column prop="name" label="姓名" width="180"></el-table-column>
      <el-table-column prop="address" label="地址"></el-table-column>
    </el-table>
    <div class="tabListPage">
      <el-pagination @size-change="handleSizeChange" 
                     @current-change="handleCurrentChange" 
                     :current-page="currentPage" 
                     :page-sizes="pageSizes" 
                     :page-size="PageSize" layout="total, sizes, prev, pager, next, jumper" 
                     :total="totalCount">
      </el-pagination>
    </div>
  </div>
</template>
<script>
  export default {
    name:'Recommendtopic',
    data(){
      return {
          // 总数据
           tableData:[],
           // 默认显示第几页
           currentPage:1,
           // 总条数，根据接口获取数据长度(注意：这里不能为空)
           totalCount:1,
           // 个数选择器（可修改）
           pageSizes:[1,2,3,4],
           // 默认每页显示的条数（可修改）
           PageSize:1,
       }
    },
    methods:{
       getData(){
             // 这里使用axios，使用时请提前引入
             axios.post(url,{
                  orgCode:1
             },{emulateJSON: true},
             {
               headers:{"Content-Type": "application/x-www-form-urlencoded;charset=utf-8",} 
              }
              ).then(reponse=>{
                   console.log(reponse)
                   // 将数据赋值给tableData
                   this.tableData=data.data.body
                   // 将数据的长度赋值给totalCount
                   this.totalCount=data.data.body.length
              }) 
         },
       // 分页
        // 每页显示的条数
       handleSizeChange(val) {
           // 改变每页显示的条数 
           this.PageSize=val
           // 注意：在改变每页显示的条数时，要将页码显示到第一页
           this.currentPage=1
       },
         // 显示第几页
       handleCurrentChange(val) {
           // 改变默认的页数
           this.currentPage=val
       },
   },
   created:function(){
         this.getData() 
   }
}
</script>

