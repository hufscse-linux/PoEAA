class Project(object):
    def __init__(self, project_id, title):
        self.project_id = project_id
        self.title = title

    def __repr__(self):
        return "<Project(title= %s) >" %(self.title)

