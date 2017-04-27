package com.greyrock.escapepod.util

class TestClassProvider(private var value : TestClass?): ResourceProvider<TestClass?> {

    override fun loadResource(): TestClass? {
        return value
    }

    override fun setResource(resource: TestClass?) {
        this.value = resource
    }

}

data class TestClass(val name : String)