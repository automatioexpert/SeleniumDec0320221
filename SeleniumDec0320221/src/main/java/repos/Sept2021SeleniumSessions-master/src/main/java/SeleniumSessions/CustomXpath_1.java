//xpath - not an attribute
//html dom -- address/path of the element
//
//1. abs xpath
///html/body/div/div[2]/ul/li[2]/a
//
//2. relative/custom xpath:
////use some xpath functions
////xpath syntax
////xpath axes
////custom xpath
//
//3. xpath uses attirbutes (id, name, any)
//4. xpath having multiple functions
//5. xpath axes: parent/child, ancestor, siblings
//
////htmltag[@attr='value']
////input[@name='email']
////htmltag[@attr1='value' and @attr2='value']
////input[@name='email' and @type='text']
//
////input[@name='email' or @type='text']
////input[@type='submit' and @value='Login']
////a[@class='list-group-item'] -- FEs -- 13
//
//text():
////htmltag[text()='value']
////a[text()='Wish List']
////h3[text()='Marketing Campaigns']
////a[text()=' Solutions for customer support']
////span[text()='value']
//
//contains(): to handle dynamic elements with dynamic properties/attributes
////htmltag[contains(@attr,'value')]
////input[contains(@id,'email')]
//
////htmltag[contains(@attr1,'value') and @attr2='value']
////input[contains(@id,'email') and @name='email']
//
////htmltag[contains(@attr1,'value') and contains(@attr2,'value')]
////input[contains(@id,'email') and contains(@name,'email')]
//
//<input id="test_123"/>
//<input id="test_234"/>
//<input id="test_456"/>
////input[contains(@id,'test_')]
//
//contains() with text():
////h2[contains(text(),'customers')]
//
////a[contains(@href,'wishlist') and contains(text(),'Wish List')]
////a[contains(@href,'wishlist') and contains(@class,'list-group-item')]
////a[contains(@href,'wishlist') and contains(@class,'list-group-item') and contains(text(),'Wish List')]
//
////input[starts-with(@id,'user')]
//<input id="firstname_123"/>
//<input id="firstname_234"/>
//<input id="firstname_456"/>
////input[starts-with(@id,'firstname_')]
//
//
////xpath with class names:
//form-control private-form__control login-email --> 3
//form-control private-form__control login-password m-bottom-3 --> 4
//
////htmltag[@class='c1 c2 c3 ... cn']
////input[@class='form-control private-form__control login-email']
//
////xpath with index:
//(//div[@class='container'])[3]//a
//((//div[@class='container'])[3]//ul)[1]
//((//div[@class='container'])[3]//ul)[5]
////ul[@class='social-links']//a
//(//input[@type='text'])[3]
//(//input[@type='text'])[position()=3]
//(//input[@type='text'])[2]
//(//input[@type='text'])[last()]
//((//div[@class='navFooterVerticalRow navAccessibility']//ul)[last()]//a)[last()]
