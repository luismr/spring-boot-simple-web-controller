package com.example.simplecontroller;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.filters.FilterPackageInfo;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.affirm.Affirm;
import com.openpojo.validation.rule.impl.*;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PojoTest {

    public static final String POJO_PACKAGE = "com.example.simplecontroller.data";
    private static final int EXPECTED_CLASS_COUNT = 1;

    @Test
    public void ensureExpectedPojoCount() {
        List<PojoClass> pojos = PojoClassFactory.getPojoClasses(POJO_PACKAGE, new FilterPackageInfo());
        Affirm.affirmEquals("Classes added/removed?", EXPECTED_CLASS_COUNT, pojos.size());
    }

    @Test
    public void testPojoStructureAndBehavior() {
        Validator validator = ValidatorBuilder.create()
                .with(new GetterMustExistRule())
                .with(new SetterMustExistRule())
                .with(new GetterTester())
                .with(new SetterTester())
                .with(new EqualsAndHashCodeMatchRule())
                .with(new NoFieldShadowingRule())
                .with(new NoPublicFieldsExceptStaticFinalRule())
                .build();

        validator.validate(POJO_PACKAGE, new FilterPackageInfo());
    }

}
