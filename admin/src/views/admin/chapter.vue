<template>
    <div>
        <p>
            <button v-on:click="list(1)" class="btn btn-white btn-default btn-round">
                <i class="ace-icon fa fa-refresh "></i>
                刷新
            </button>
        </p>
        <pagination ref ="pagination" v-bind:list="list"></pagination>

        <table id="simple-table" class="table  table-bordered table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>名称</th>
                <th>课程ID</th>
                <th>操作</th>
            </tr>
            </thead>

            <tbody>
            <tr v-for ="chaper in chapters">
                <td>{{chaper.id}}</td>
                <td>{{chaper.name}}</td>
                <td>{{chaper.courseId}}</td>
                <td>
                    <div class="hidden-sm hidden-xs btn-group">
                        <button class="btn btn-xs btn-success">
                            <i class="ace-icon fa fa-check bigger-120"></i>
                        </button>

                        <button class="btn btn-xs btn-info">
                            <i class="ace-icon fa fa-pencil bigger-120"></i>
                        </button>

                        <button class="btn btn-xs btn-danger">
                            <i class="ace-icon fa fa-trash-o bigger-120"></i>
                        </button>

                        <button class="btn btn-xs btn-warning">
                            <i class="ace-icon fa fa-flag bigger-120"></i>
                        </button>
                    </div>

                    <div class="hidden-md hidden-lg">
                        <div class="inline pos-rel">
                            <button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown" data-position="auto">
                                <i class="ace-icon fa fa-cog icon-only bigger-110"></i>
                            </button>

                            <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                <li>
                                    <a href="#" class="tooltip-info" data-rel="tooltip" title="View">
																			<span class="blue">
																				<i class="ace-icon fa fa-search-plus bigger-120"></i>
																			</span>
                                    </a>
                                </li>

                                <li>
                                    <a href="#" class="tooltip-success" data-rel="tooltip" title="Edit">
																			<span class="green">
																				<i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
																			</span>
                                    </a>
                                </li>

                                <li>
                                    <a href="#" class="tooltip-error" data-rel="tooltip" title="Delete">
																			<span class="red">
																				<i class="ace-icon fa fa-trash-o bigger-120"></i>
																			</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
    </div>

</template>

<script>
    import Pagination from "../../components/pagination";
    export default {
        name: "chapter",
        components: {Pagination},
        data:function(){
            return {
                chapters:[]
            }
        },
        mounted:function () {
            let _this = this;
            _this.$refs.pagination.size=10;
            _this.list(1);
        },
        methods:{
            list(page){
                let _this = this
                    _this.$axios.post("http://127.0.0.1:9000/business/admin/chapter/list",{
                        "page":page,
                        "size":_this.$refs.pagination.size,
                    }).then((response)=>{

                    if (response.status == 200) {
                        console.log(response.data)
                        _this.chapters= response.data.data.list
                        _this.$refs.pagination.render(page,response.data.data.total)
                    }
                })
            }
        }
    }
</script>


<style scoped>

</style>