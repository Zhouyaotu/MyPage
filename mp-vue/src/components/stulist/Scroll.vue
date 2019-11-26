<template>
  <div class="infinite-list-wrapper" style="overflow:auto">
    <ul
      class="list"
      v-infinite-scroll="load"
      infinite-scroll-disabled="disabled">
      <div v-for="stu in stulist" v-bind:key="stu.base.uid" class="list-item">
        <el-container type="flex">
          <el-aside width="250px">
            <Headimg/>
          </el-aside>
          <el-main>
            <el-row type="flex" justify="start">
              {{stu.base.username}}
            </el-row>
            <el-row type="flex" justify="start">
              {{stu.detail.homeProvince}}
            </el-row>
            <el-row type="flex" justify="start">
              <Stutags/>
            </el-row>
          </el-main>
          
        </el-container>
      </div>
    </ul>
    <p v-if="loading">加载中...</p>
    <p v-if="noMore">到底了</p>
  </div>
</template>

<script>
  import Headimg from '@/components/common/Headimg'
  import Stutags from '@/components/common/Stutags'
  export default {
    name:'Scroll',
    data () {
      return {
        //count: 50,
        stulist:[],
        resCode: 0,
        loading: false
      }
    },
    computed: {
      noMore () {
        return this.resCode !== 0
      },
      disabled () {
        return this.loading || this.noMore
      }
    },
    components:{
      Headimg,
      Stutags,
    },
    methods: {
      load () {
          this.loading = true
          setTimeout(() => {
            var _this = this
            this.$axios.get('/user/get-all-user-info').then(resp => {
            if (resp && resp.status === 200 ) {
              _this.stulist = resp.data.attribute
              _this.resCode = resp.data.code
            }
          })
          this.loading = false
        }, 500)
      }
    }
  }
</script>